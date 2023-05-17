window.addEventListener("DOMContentLoaded", () => {

    const galleryForm = document.getElementById("gallery-edit-form");
    const gallerySubmitButton = document.getElementById("gallery-button");

    gallerySubmitButton.addEventListener("click", (e) => {
        e.preventDefault();
        e.target.disabled = true;
        const formData = new FormData(galleryForm);

        const galleryId = formData.get("galleryId");

        if (galleryId) {
            $.ajax({
                type: "put",
                url : "/api/galleries/" + galleryId,
                data : formData,
                processData: false,
                contentType: false,
                success : (data) => {
                    console.log(data);
                    location.href = "/galleries/" + galleryId;
                },
                error : (error) => {
                    const data = JSON.parse(error.responseText)
                    alert(data.errorMessage);
                },
                complete : () => {
                    e.target.disabled = false;
                }
            })
        } else {
            $.ajax({
                type: "post",
                url : "/api/galleries",
                data : formData,
                processData: false,
                contentType: false,
                dataType : "json",
                success : (res) => {
                    console.log(res);
                    location.href = "/galleries/" + res.data;
                },
                error : (error, textStatus , a) => {
                    const data = JSON.parse(error.responseText)
                    alert(data.errorMessage);
                },
                complete : () => {
                    e.target.disabled = false;
                }
            })
        }

    })

    $('#year').datepicker({
        format: "yyyy",
        viewMode: "years",
        minViewMode: "years",
        autoclose:true //to close picker once year is selected
    })

    let previewImage = document.getElementById("preview-image");

    if (previewImage) {
        let fileElement = document.getElementById("file");

        fileElement.addEventListener("change", (e) => {
            if (e.target.files.length <= 0) return;

            let file = e.target.files[0];
            let fileReader = new FileReader();
            fileReader.onload = ({target}) => {
                if (file.type.startsWith("video")) {
                    let _videoEl = previewImage.querySelector("video");
                    if (_videoEl) {
                        _videoEl.querySelector("source").src = target.result;
                    } else {
                        let videoEl = document.createElement("video");
                        let sourceEl = document.createElement("source");
                        videoEl.controls = true;
                        sourceEl.src = target.result;
                        sourceEl.type = file.type;
                        videoEl.append(sourceEl);
                        previewImage.append(videoEl);
                    }
                } else {
                    let _imgEl = previewImage.querySelector("img");
                    if (_imgEl) {
                        _imgEl.src = target.result;
                    } else {
                        let imaEl = document.createElement("img");
                        imaEl.style.maxWidth = "600px";
                        imaEl.src = target.result;
                        previewImage.append(imaEl);
                    }

                }

            }

            fileReader.readAsDataURL(file);
        })

    }
});