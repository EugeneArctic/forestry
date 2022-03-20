package com.example.application.views.empty

import com.example.application.views.MainLayout
import com.flowingcode.vaadin.addons.googlemaps.GoogleMap
import com.flowingcode.vaadin.addons.googlemaps.GoogleMapPoint
import com.flowingcode.vaadin.addons.googlemaps.GoogleMapPolygon
import com.flowingcode.vaadin.addons.googlemaps.LatLon
import com.vaadin.flow.component.dependency.NpmPackage
//import com.vaadin.componentfactory.maps.model.*
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextFieldVariant
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import java.util.*


@PageTitle("Owners")
@Route(value = "owner", layout = MainLayout::class)

class Owner : VerticalLayout() {
    init {

        val gmaps = GoogleMap("AIzaSyAsEXA5qhmt1BjNSWX6W-ssAmG4MKdcsKo", null, "en")
        gmaps.setMapType(GoogleMap.MapType.SATELLITE)
        gmaps.setSizeFull()
        gmaps.center = LatLon( 60.919625648750454, 23.812739282884547)
        gmaps.addMarker("Center", LatLon(60.919625648750454, 23.812739282884547), true, "")
        val gmp: GoogleMapPolygon = gmaps.addPolygon(
            Arrays.asList(
                GoogleMapPoint(gmaps.center),
                GoogleMapPoint(gmaps.center.lat, gmaps.center.lon + 1),
                GoogleMapPoint(gmaps.center.lat + 1, gmaps.center.lon)
            )
        )
        add(gmaps)

        val txt = com.vaadin.flow.component.textfield.TextField().apply {
            placeholder = "Search"
            prefixComponent = VaadinIcon.SEARCH.create()
            addThemeVariants(TextFieldVariant.LUMO_SMALL)
            style["width"] = "12em"
            style["background-color"] = "white"
            style["border-radius"]= "25px"
        }


        add(txt)
        setSizeFull()
        justifyContentMode = FlexComponent.JustifyContentMode.CENTER
        defaultHorizontalComponentAlignment = FlexComponent.Alignment.CENTER
        style["text-align"] = "center"
    }


}