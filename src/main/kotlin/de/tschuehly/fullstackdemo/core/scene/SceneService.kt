package de.tschuehly.fullstackdemo.core.scene

import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.random.Random

@Service
class SceneService {
    private val sceneData = mutableListOf(
        Scene(1, "Bruno", "Wagner", "123456", "nah@outlook.com", LocalDate.now())
    )

    fun savescene(scene: Scene): Scene {
        if (scene.id != null) {
            sceneData.replaceAll {
                if (it.id == scene.id) scene else it
            }
            return scene
        }
        scene.id = Random.nextInt()
        sceneData.add(scene)
        return scene

    }


    fun getscene(sceneId: Int): Scene {
        return sceneData.find { it.id == sceneId }
            ?: throw NoSuchElementException("No scene with Id: $sceneId found")
    }

    fun getsceneData() = sceneData
}

