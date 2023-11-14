package de.tschuehly.fullstackdemo.web.page.upload

import de.tschuehly.fullstackdemo.core.mediaUpload.UploadService
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import jdk.jfr.Percentage

@ViewComponent
class UploadComponent(
    uploadService: UploadService
) {

    fun render() = UploadView(Status.Init, 0)
    data class UploadView(
        var status: Status,
        var percentage: Int,
        val postURL :String = "upload"
    ) : ViewContext

    enum class Status(val displayName: String) {
        Init("Init"),
        Uploading("Uploading"),
        Done("Done"),
        Error("Error"),
    }
}
