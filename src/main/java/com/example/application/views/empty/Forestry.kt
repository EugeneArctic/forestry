package com.example.application.views.empty

import com.example.application.views.MainLayout
import com.vaadin.flow.component.UI
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.html.H2
import com.vaadin.flow.component.html.Image
import com.vaadin.flow.component.html.Paragraph
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route
import com.vaadin.flow.router.RouteAlias

@PageTitle("Forestry")
@Route(value = "forestry", layout = MainLayout::class)
@RouteAlias(value = "", layout = MainLayout::class)

class Forestry : VerticalLayout() {
    init {
//        isSpacing = false
        val img = Image("https://i.ibb.co/gRSN4L4/yolka-removebg-preview.png", "placeholder plant")
        val h2 = H2("Forestry").apply {
            style["color"] = "#497c4f"
            style["margin-bottom"] = "0"
        }
        val hl1 = HorizontalLayout(img,h2).apply {
            setHorizontalComponentAlignment(FlexComponent.Alignment.END,h2)
        }

        val  owners = Button("Forest owners",Image("images/forward.svg","dd")).apply {
            style["color"] = "black"
            style["background-color"] = "#5ca662"
            style["border-radius"]= "25px"
            width ="15em"
            addClickListener { UI.getCurrent().navigate("owner") }
        }
        val  company = Button("Companies",Image("images/cog.svg","dd")).apply {
            style["color"] = "black"
            style["background-color"] = "#87ff96"
            style["border-radius"]= "25px"
            width ="15em"
            addClickListener { UI.getCurrent().navigate("company") }
        }
        val  invest = Button("Investors",Image("images/trending-up.svg","dd")).apply {
            style["color"] = "black"
            style["background-color"] = "#8487ff"
            style["border-radius"]= "25px"
            width ="15em"
            addClickListener { UI.getCurrent().navigate("") }
        }

        add(hl1)
        add(owners,company,invest)
        setSizeFull()
        justifyContentMode = JustifyContentMode.CENTER
        defaultHorizontalComponentAlignment = FlexComponent.Alignment.CENTER
        style["text-align"] = "center"
    }
}
