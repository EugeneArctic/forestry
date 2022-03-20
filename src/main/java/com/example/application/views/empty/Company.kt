package com.example.application.views.empty

import com.example.application.views.MainLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route

@PageTitle("Company")
@Route(value = "company", layout = MainLayout::class)

class Company: VerticalLayout() {
}