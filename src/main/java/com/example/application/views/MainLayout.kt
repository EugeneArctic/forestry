package com.example.application.views

import com.example.application.views.empty.Company
import com.example.application.views.empty.Forestry
import com.example.application.views.empty.Owner
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.applayout.AppLayout
import com.vaadin.flow.component.applayout.DrawerToggle
import com.vaadin.flow.component.button.ButtonVariant
import com.vaadin.flow.component.dependency.NpmPackage
import com.vaadin.flow.component.html.*
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.RouterLink


//import com.example.application.views.empty.Forestry;
/**
 * The main view is a top-level placeholder for other views.
 */
class MainLayout : AppLayout() {
    /**
     * A simple navigation item component, based on ListItem element.
     */
    class MenuItemInfo(menuTitle: String?, iconClass: String, private val view: Class<out Component>) :
        ListItem() {
        init {
            val link = RouterLink()
            link.addClassNames("menu-item-link")
            link.setRoute(view)
            val text = Span(menuTitle)
            text.addClassNames("menu-item-text")
            link.add(LineAwesomeIcon(iconClass), text)
            add(link)
        }

        fun getView(): Class<*> {
            return view
        }

        /**
         * Simple wrapper to create icons using LineAwesome iconset. See
         * https://icons8.com/line-awesome
         */
        @NpmPackage(value = "line-awesome", version = "1.3.0")
        class LineAwesomeIcon(lineawesomeClassnames: String) : Span() {
            init {
                addClassNames("menu-item-icon")
                if (!lineawesomeClassnames.isEmpty()) {
                    addClassNames(lineawesomeClassnames)
                }
            }
        }
    }

    private var viewTitle: H1? = null

    init {
        primarySection = Section.DRAWER
        addToNavbar(true, createHeaderContent())
        addToDrawer(createDrawerContent())
    }

    private fun createHeaderContent(): Component {
        val toggle = DrawerToggle()
        toggle.addClassNames("view-toggle")
        toggle.addThemeVariants(ButtonVariant.LUMO_CONTRAST)
        toggle.element.setAttribute("aria-label", "Menu toggle")
        viewTitle = H1()
        viewTitle!!.addClassNames("view-title")
        val header = Header(toggle, viewTitle)
        header.addClassNames("view-header")
        return header
    }

    private fun createDrawerContent(): Component {
        val appName = H2("Forestry")
        appName.addClassNames("app-name")
        val section = Section(
            appName,
            createNavigation(), createFooter()
        )
        section.addClassNames("drawer-section")
        return section
    }

    private fun createNavigation(): Nav {
        val nav = Nav()
        nav.addClassNames("menu-item-container")
        nav.element.setAttribute("aria-labelledby", "views")

        // Wrap the links in a list; improves accessibility
        val list = UnorderedList()
        list.addClassNames("navigation-list")
        nav.add(list)
        for (menuItem in createMenuItems()) {
            list.add(menuItem)
        }
        return nav
    }

    private fun createMenuItems(): Array<MenuItemInfo> {
        return arrayOf(
//            MenuItemInfo("Forestry", "la la-file", EmptyView::class.java),
            MenuItemInfo("Forestry", "la la-file", Forestry::class.java),
            MenuItemInfo("Owner", "la la-file", Owner::class.java),
            MenuItemInfo("Company", "la la-file", Company::class.java),

        )
    }

    private fun createFooter(): Footer {
        val layout = Footer()
        layout.addClassNames("footer")
        return layout
    }

    override fun afterNavigation() {
        super.afterNavigation()
        viewTitle!!.text = currentPageTitle
    }

    private val currentPageTitle: String
        private get() {
            val title = content.javaClass.getAnnotation(PageTitle::class.java)
            return if (title == null) "" else title.value
        }
}