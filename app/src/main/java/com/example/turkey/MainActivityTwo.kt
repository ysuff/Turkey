package com.example.turkey

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.turkey.databinding.ActivityMainTwoBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place.Field
import com.google.android.libraries.places.api.net.PlacesClient
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.AutocompleteActivity
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
import com.google.android.libraries.places.api.net.FetchPlaceRequest
import com.google.maps.DirectionsApi
import com.google.maps.GeoApiContext
import com.google.maps.model.DirectionsResult
import com.google.maps.model.TravelMode

class MainActivityTwo : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMainTwoBinding
    private var mGoogleMap: GoogleMap? = null
    private lateinit var geoApiContext: GeoApiContext
    private lateinit var placesClient: PlacesClient
    private lateinit var btnZoomIn: Button
    private lateinit var btnZoomOut: Button
    private lateinit var btnMyLocation: Button
    private lateinit var btnCancelSelection: Button
    private lateinit var mapBackButton: Button

    private var origin: LatLng? = null
    private var destination: LatLng? = null
    private var originMarker: Marker? = null
    private var destinationMarker: Marker? = null

    private val LOCATION_PERMISSION_REQUEST_CODE = 1
    private val AUTOCOMPLETE_REQUEST_CODE = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnZoomIn = binding.btnZoomIn
        btnZoomOut = binding.btnZoomOut
        mapBackButton = binding.mapBackButton
        btnMyLocation = binding.btnMyLocation
        btnCancelSelection = findViewById(R.id.btnCancelSelection)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        Places.initialize(applicationContext, getString(R.string.api_key))
        placesClient = Places.createClient(this)

        geoApiContext = GeoApiContext.Builder().apiKey(getString(R.string.api_key)).build()

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
        }

        btnZoomIn.setOnClickListener {
            mGoogleMap?.animateCamera(CameraUpdateFactory.zoomIn())
        }

        btnZoomOut.setOnClickListener {
            mGoogleMap?.animateCamera(CameraUpdateFactory.zoomOut())
        }

        btnMyLocation.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mGoogleMap?.isMyLocationEnabled = true
                val myLocation = mGoogleMap?.myLocation
                if (myLocation != null) {
                    val myLatLng = LatLng(myLocation.latitude, myLocation.longitude)
                    mGoogleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(myLatLng, 15f))
                }
            } else {
                Toast.makeText(this, "Location permission not granted", Toast.LENGTH_SHORT).show()
            }
        }

        btnCancelSelection.setOnClickListener {
            clearSelection()
        }

        mapBackButton.setOnClickListener {
            supportFragmentManager.popBackStack()
            finish()
        }

        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { searchPlace(it) }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            mGoogleMap?.let { setupMap(it) }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap

        mGoogleMap?.setOnMapClickListener { latLng ->
            if (origin == null) {
                origin = latLng
                originMarker = mGoogleMap?.addMarker(MarkerOptions().position(latLng).title("Origin"))
                btnCancelSelection.visibility = Button.VISIBLE
            } else if (destination == null) {
                destination = latLng
                destinationMarker = mGoogleMap?.addMarker(MarkerOptions().position(latLng).title("Destination"))
                openGoogleMapsDirections(origin!!, destination!!)
            } else {
                clearSelection()
                origin = latLng
                originMarker = mGoogleMap?.addMarker(MarkerOptions().position(latLng).title("Origin"))
                btnCancelSelection.visibility = Button.VISIBLE
            }
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            setupMap(googleMap)
        }
    }

    private fun setupMap(googleMap: GoogleMap) {
        val location = LatLng(38.0049722, 32.5208611)
        googleMap.addMarker(MarkerOptions().position(location).title("My Home"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(location))

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            googleMap.isMyLocationEnabled = true
        }
    }

    private fun searchPlace(query: String) {
        val request = FindAutocompletePredictionsRequest.builder()
            .setQuery(query)
            .build()

        placesClient.findAutocompletePredictions(request)
            .addOnSuccessListener { response ->
                val predictions = response.autocompletePredictions
                if (predictions.isNotEmpty()) {
                    val prediction = predictions[0]
                    val placeId = prediction.placeId

                    val placeFields = listOf(Field.ID, Field.NAME, Field.LAT_LNG)
                    val fetchPlaceRequest = FetchPlaceRequest.builder(placeId, placeFields).build()

                    placesClient.fetchPlace(fetchPlaceRequest).addOnSuccessListener { fetchPlaceResponse ->
                        val place = fetchPlaceResponse.place
                        val latLng = place.latLng
                        if (latLng != null) {
                            mGoogleMap?.addMarker(MarkerOptions().position(latLng).title(place.name))
                            mGoogleMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f))
                        }
                    }.addOnFailureListener { exception ->
                        Toast.makeText(this, "Place not found: ${exception.message}", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this, "No predictions found", Toast.LENGTH_LONG).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Prediction fetching failed: ${exception.message}", Toast.LENGTH_LONG).show()
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                val place = Autocomplete.getPlaceFromIntent(data!!)
                val latLng = place.latLng
                if (latLng != null) {
                    mGoogleMap?.addMarker(MarkerOptions().position(latLng).title(place.name))
                    mGoogleMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f))
                }
            } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                val status = Autocomplete.getStatusFromIntent(data!!)
                Toast.makeText(this, "Error: ${status.statusMessage}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun openGoogleMapsDirections(origin: LatLng, destination: LatLng) {
        val gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=${origin.latitude},${origin.longitude}&destination=${destination.latitude},${destination.longitude}&travelmode=driving")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        } else {
            Toast.makeText(this, "Google Maps is not installed.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun calculateRoute(origin: LatLng, destination: LatLng) {
        try {
            val directionsResult: DirectionsResult = DirectionsApi.newRequest(geoApiContext)
                .mode(TravelMode.DRIVING)
                .origin(com.google.maps.model.LatLng(origin.latitude, origin.longitude))
                .destination(com.google.maps.model.LatLng(destination.latitude, destination.longitude))
                .await()

            if (directionsResult.routes.isNotEmpty()) {
                val route = directionsResult.routes[0]
                val decodedPath = route.overviewPolyline.decodePath()

                runOnUiThread {
                    val polylineOptions = PolylineOptions()
                        .addAll(decodedPath.map { LatLng(it.lat, it.lng) })
                        .color(ContextCompat.getColor(this, R.color.red))
                    mGoogleMap?.addPolyline(polylineOptions)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            runOnUiThread {
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun clearSelection() {
        mGoogleMap?.clear()
        origin = null
        destination = null
        originMarker = null
        destinationMarker = null
        btnCancelSelection.visibility = Button.GONE
    }
}
