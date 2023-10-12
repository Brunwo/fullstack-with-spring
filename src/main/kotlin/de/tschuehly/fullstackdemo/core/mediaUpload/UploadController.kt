package de.tschuehly.fullstackdemo.core.mediaUpload

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.Mapping
import org.springframework.web.bind.annotation.PostMapping

@Service
class UploadController {


    @PostMapping("api/upload")
    fun upload() {

    }
}