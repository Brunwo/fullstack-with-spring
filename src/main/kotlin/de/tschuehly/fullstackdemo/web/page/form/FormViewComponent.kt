package de.tschuehly.fullstackdemo.web.page.form

import de.tschuehly.fullstackdemo.web.component.scene.form.SceneFormViewComponent
import de.tschuehly.spring.viewcomponent.core.component.ViewComponent
import de.tschuehly.spring.viewcomponent.core.toProperty
import de.tschuehly.spring.viewcomponent.thymeleaf.ViewContext

@ViewComponent
 class FormViewComponent(
     val sceneFormViewComponent: SceneFormViewComponent
)  {
    fun render() = FormView()
//sceneFormViewComponent.render()


    //testing copilot
class FormView : ViewContext
}