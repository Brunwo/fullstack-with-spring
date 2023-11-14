package de.tschuehly.fullstackdemo.web.component.util.table

import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty

@ViewComponent
class TableViewComponent {
    fun render(table: Table) = table
    data class Table(
        val headerList: List<String>,
        val tableData: List<List<String>>

    ) : ViewContext
}