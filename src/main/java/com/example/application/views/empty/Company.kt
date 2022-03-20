package com.example.application.views.empty

import com.example.application.views.MainLayout
import com.github.appreciated.apexcharts.ApexChartsBuilder
import com.github.appreciated.apexcharts.config.builder.ChartBuilder
import com.github.appreciated.apexcharts.config.builder.LegendBuilder
import com.github.appreciated.apexcharts.config.builder.ResponsiveBuilder
import com.github.appreciated.apexcharts.config.chart.Type
import com.github.appreciated.apexcharts.config.legend.Position
import com.github.appreciated.apexcharts.config.*
import com.github.appreciated.apexcharts.config.responsive.builder.OptionsBuilder
import com.vaadin.flow.component.Html
import com.vaadin.flow.component.html.Div
import com.vaadin.flow.component.html.Image
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.Route


@PageTitle("Company")
@Route(value = "company", layout = MainLayout::class)

class Company: VerticalLayout() {

  init {
      val d1 = Image("https://i.ibb.co/ByFrVGq/532-5327639-pie-chart-computer-icons-pie-chart-icon-transparent-removebg-preview.png",
      "sss")
      val d2 = Image("https://i.ibb.co/ByFrVGq/532-5327639-pie-chart-computer-icons-pie-chart-icon-transparent-removebg-preview.png",
          "sss")
      add(d1,d2)

      justifyContentMode = FlexComponent.JustifyContentMode.CENTER
      defaultHorizontalComponentAlignment = FlexComponent.Alignment.CENTER
      style["text-align"] = "center"

  }




}

class DonutChartExample : Div() {
    init {
        val donutChart = ApexChartsBuilder.get()
            .withChart(ChartBuilder.get().withType(Type.donut).build())
            .withLegend(
                LegendBuilder.get()
                    .withPosition(Position.right)
                    .build()
            )
            .withSeries(44.0, 55.0, 41.0, 17.0, 15.0)
            .withResponsive(
                ResponsiveBuilder.get()
                    .withBreakpoint(480.0)
                    .withOptions(
                        OptionsBuilder.get()
                            .withLegend(
                                LegendBuilder.get()
                                    .withPosition(Position.bottom)
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
            .build()
        add(donutChart)
        setWidth("100%")
    }
}