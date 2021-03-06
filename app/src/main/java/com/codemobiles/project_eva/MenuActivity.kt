package com.codemobiles.project_eva

import android.Manifest
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toFile
import com.codemobiles.project_eva.MyFeedRecyclerViewHolder.Companion.currCondo
import com.jaiselrahman.filepicker.activity.FilePickerActivity
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import kotlinx.android.synthetic.main.activity_menu.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import pl.aprilapps.easyphotopicker.EasyImage
import pl.aprilapps.easyphotopicker.MediaFile
import pl.aprilapps.easyphotopicker.MediaSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MenuActivity : AppCompatActivity() {

    var textView: TextView? = null
    lateinit var mEasyImage: EasyImage

//    val mPicture : ImageView = ImageView(findViewById<>(R.id.item_tab_menu_img))
    var imageList = arrayOf<Int>(
        R.drawable.condo_001,
        R.drawable.condo_002,
        R.drawable.condo_003,
        R.drawable.condo_ex2
    )
//TOdo
    val title:String? = currCondo.projectID

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

//        mPicture.setImageResource(imageList[1])

        textView = this.menuHeader
        textView!!.text = title

        checkRuntimePermission()
    }

    private fun checkRuntimePermission() {

        val _permissions =
            arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        Dexter.withActivity(this)
            .withPermissions(*_permissions)
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    token?.continuePermissionRequest()
                }

                override fun onPermissionsChecked(report: MultiplePermissionsReport) {

                    if (report.areAllPermissionsGranted()) {
                        Toast.makeText(
                            getApplicationContext(),
                            "Permission Granted",
                            Toast.LENGTH_LONG
                        ).show()

                        mEasyImage = EasyImage.Builder(applicationContext)
                            .setCopyImagesToPublicGalleryFolder(true)
                            .setFolderName("EasyImage")
                            .allowMultiple(true)
                            .build()
                    } else {
                        finish()
                    }
                }


            })
            .check()
    }

    fun onClickCamera(view: View) {
        checkRuntimePermission()
        mEasyImage.openCameraForImage(this)
    }

    fun onClickFill(view: View){
        val intent = Intent(this, FillActivity::class.java)
        startActivity(intent)
    }

    fun onClickGallery(view: View) {
        mEasyImage.openGallery(this)
    }

    fun onClickMap(view: View) {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }
    var FILE_REQUEST_CODE = 10
    fun onClickFile(view: View) {
        val intent = Intent(this, FilePickerActivity::class.java)
        startActivityForResult(intent, FILE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == FILE_REQUEST_CODE) {
            val files: ArrayList<com.jaiselrahman.filepicker.model.MediaFile> =
                data!!.getParcelableArrayListExtra(
                    FilePickerActivity.MEDIA_FILES
                )
            val file = files[0]
            val fileData = file.uri.toFile()
            var data = fileData.readBytes()
            upload(file.name, data)
            return
        }


        mEasyImage.handleActivityResult(
            requestCode,
            resultCode,
            data,
            this,
            object : pl.aprilapps.easyphotopicker.EasyImage.Callbacks {
                override fun onCanceled(source: MediaSource) {
                }

                override fun onImagePickerError(error: Throwable, source: MediaSource) {
                }

                override fun onMediaFilesPicked(imageFiles: Array<MediaFile>, source: MediaSource) {
                    val imageFile = imageFiles[0].file
//                    Glide.with(applicationContext).load(imageFile).into(imagePreview)
                    upload(imageFile.name, imageFile!!.readBytes())
                }

            })
    }

    private fun upload(_fileName: String, _baos: ByteArray) {

        // Sent Data to server
        val _username = "admin"
        val _password = "admin"

        val _reqFile = RequestBody.create(MediaType.parse("multipart/form-data"), _baos)
        val _body = MultipartBody.Part.createFormData("userfile", _fileName, _reqFile)  //images
        val _bodyUsername = RequestBody.create(MediaType.parse("text/plain"), _username)
        val _bodyPassword = RequestBody.create(MediaType.parse("text/plain"), _password)


//        val call = RetrofitClient.client.postImageNodeJS(_body, _bodyUsername, _bodyPassword)
//        call.enqueue(object : Callback<ResponseBody> {
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                Toast.makeText(applicationContext, t.toString(), Toast.LENGTH_LONG).show()
//            }
//
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                Toast.makeText(applicationContext, response.body()!!.string(), Toast.LENGTH_LONG)
//                    .show()
//            }
//
//        })

    }
}