package de.tschuehly.fullstackdemo.web.component.scene.action

import de.tschuehly.fullstackdemo.core.scene.Scene
import de.tschuehly.fullstackdemo.core.scene.SceneService
import de.tschuehly.spring.viewcomponent.core.action.PutViewAction
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import java.time.LocalDate

@ViewComponent
class SceneActionViewComponent(
    private val sceneService: SceneService
) {
    fun render(sceneId: Int? = null) = ViewContext(
        "scene" toProperty getscene(sceneId)
    )

    fun getscene(sceneId: Int?): sceneFormDTO {
        if (sceneId != null) {
            sceneService.getscene(sceneId).also { return sceneFormDTO(it) }
        }
        return sceneFormDTO(null, "", "", "", "", LocalDate.now())
    }

    @PutViewAction
    fun savescene(sceneFormDTO: sceneFormDTO): ViewContext {
        val scene = sceneService.savescene(sceneFormDTO.convertToscene())
        return render(scene.id);
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