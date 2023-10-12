/*
package de.tschuehly.fullstackdemo.core.mediaUpload

class UploadService {

    // 1. The Interface

// --> Two ways to do it,

    @Multipart
    @POST("the_endpoint")
    suspend fun postImage(
        @Part profile_photo: MultipartBody.Part,
        @Part ("profile_photo") requestBody: RequestBody
    ):  UploadPhotoResponse

    @POST("the_endpoint")
    suspend fun updateProfile(
        @Body body: RequestBody
    ): UpdateProfileResponse


// Assuming you will have get the image uri when a user picks the image. One easy way is to convert the uri to a file, and convert the file to a
// a Multipart


// Converting the Uri to a file
// You can create a simple utility class

    class UriToFile(context: Context) {
        private val applicationContext = context.applicationContext
        fun getImageBody(imageUri: Uri): File {
            val parcelFileDescriptor = applicationContext.contentResolver.openFileDescriptor(
                imageUri,
                "r",
                null
            )
            val file = File(
                applicationContext.cacheDir,
                applicationContext.contentResolver.getFileName(imageUri)
            )
            val inputStream = FileInputStream(parcelFileDescriptor?.fileDescriptor)
            val outputStream = FileOutputStream(file)
            inputStream.copyTo(outputStream)
            return file
        }
    }

    @SuppressLint("Range")
    fun ContentResolver.getFileName(uri: Uri): String {
        var name = ""
        val cursor = query(
            uri, null, null,
            null, null
        )
        cursor?.use {
            it.moveToFirst()
            name = it.getString(it.getColumnIndex(OpenableColumns.DISPLAY_NAME))
        }
        return name
    }


    // Calling the api

    private fun updateUserProfile() {

        val file = UriToFile(requireContext()).getImageBody(theUri)
        val requestFile: RequestBody = file.asRequestBody("multipart/form-data".toMediaTypeOrNull())

        val builder: MultipartBody.Builder = MultipartBody.Builder().setType(MultipartBody.FORM)

        builder.addFormDataPart("first_name", firstName) // whatever data you will pass to the the request body
            .addFormDataPart("profile_photo", file.name, requestFile) // the profile photo
        // make sure the name (ie profile_photo), matches your api, that is name of the key.


        val requestBody: RequestBody = builder.build()

        // pass the request body to make your retrofit call
        viewModel.updateUserProfile(requestBody).observe(viewLifecycleOwner){......
        }
    }
}*/
