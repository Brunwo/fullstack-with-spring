
package de.tschuehly.fullstackdemo.core.mediaUpload

import de.tschuehly.fullstackdemo.common.ApiConfig
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.io.File
import java.io.FileWriter


@Service
public class UploadService {

    //@Multipart
    @PostMapping(ApiConfig.upload.post)

    //@PostMapping("/")
    fun handleFileUpload(
        @RequestParam("file") file: MultipartFile,
        redirectAttributes: RedirectAttributes
    ): String? {

    val inputStream = file.inputStream
    val outputStream = File("path/to/file").outputStream()

    inputStream.use { outputStream.use { outputStream.write(inputStream.read()) }  }

//        arrayOf(   inputStream, outputStream).use {
//            outputStream.write(inputStream.read())
//        }
      //  file.inputStream.copyTo( )
        //storageService.store(file)
        redirectAttributes.addFlashAttribute(
            "message",
            "You successfully uploaded " + file.originalFilename + "!"
        )
        return "redirect:/"
    }

}
