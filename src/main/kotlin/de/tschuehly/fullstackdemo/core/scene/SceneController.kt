package de.tschuehly.fullstackdemo.core.scene

import de.tschuehly.fullstackdemo.common.ApiConfig
import de.tschuehly.fullstackdemo.web.component.scene.form.SceneFormViewComponent
import de.tschuehly.fullstackdemo.web.component.util.toast.ToastViewComponent
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PutMapping

@Controller
class SceneController(
    private val sceneService: SceneService,
    private val toastViewComponent: ToastViewComponent
) {

    @PutMapping(ApiConfig.scene.put, headers = ["HX-Request"]) // htmx requests only
    fun savescene(
        sceneFormDTO: SceneFormViewComponent.sceneFormDTO,
        response: HttpServletResponse
    ): ViewContext {
        sceneService.savescene(sceneFormDTO.convertToscene())
        response.addHeader("HX-Retarget", "#toast")
        return toastViewComponent.render(
            "Successfully saved scene",
            2000
        )
    }
}