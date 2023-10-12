package de.tschuehly.fullstackdemo.web.component.scene.form

import de.tschuehly.fullstackdemo.common.ApiConfig
import de.tschuehly.fullstackdemo.core.scene.Scene
import de.tschuehly.fullstackdemo.core.scene.SceneService
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import de.tschuehly.spring.viewcomponent.core.toProperty
import java.time.LocalDate

@ViewComponent
class SceneFormViewComponent(
    private val sceneService: SceneService
) {
    fun render(sceneId: Int? = null) = ViewContext(
        "scenePost" toProperty ApiConfig.scene.put,
        "scene" toProperty getscene(sceneId)
    )

    fun getscene(sceneId: Int?): sceneFormDTO {
        if (sceneId != null) {
            sceneService.getscene(sceneId).also { return sceneFormDTO(it) }
        }
        return sceneFormDTO(null,"", "", "", "", LocalDate.now())
    }

    class sceneFormDTO(
        val id: Int?,
        val firstName: String,
        val lastName: String,
        val phoneNumber: String,
        val email: String,
        val birthDate: LocalDate
    ) {

        constructor(scene: Scene) : this(
            scene.id,
            scene.firstName,
            scene.lastName,
            scene.phoneNumber,
            scene.email,
            scene.birthDate
        )

        fun convertToscene() = Scene(
            this.id,
            this.firstName,
            this.lastName,
            this.phoneNumber,
            this.email,
            this.birthDate
        )
    }
}