document.addEventListener("DOMContentLoaded", () => {

    const noticeForm = document.getElementById("notice-edit-form");
    const noticeSubmitButton = document.getElementById("notice-button");

    noticeSubmitButton.addEventListener("click", (e) => {
        e.preventDefault();
        e.target.disabled = true;

        const formData = new FormData(noticeForm);

        for (const [key, value] of formData.entries()) {
            console.log(key, value);
        };

        const noticeId = formData.get("noticeId");

        if (noticeId) {
            $.ajax({
                type: "put",
                url : "/api/notices/" + noticeId,
                data : formData,
                processData: false,
                contentType: false,
                success : (data) => {
                    console.log(data);
                    location.href = "/notices";
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
                url : "/api/notices",
                data : formData,
                processData: false,
                contentType: false,
                dataType: 'json',
                success : (res) => {
                    console.log(res);
                    location.href = "/notices/";
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