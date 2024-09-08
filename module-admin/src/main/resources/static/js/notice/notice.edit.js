document.addEventListener("DOMContentLoaded", () => {

    const noticeForm = document.getElementById("notice-edit-form");
    const noticeSubmitButton = document.getElementById("notice-button");
    const noticeDeleteButton = document.getElementById("notice-delete-button");
    const previewFile = document.getElementById("preview-image");

    noticeDeleteButton.addEventListener("click", noticeDeleteBtnClickHandler);

    // 공지사항 에디터 구축
    const editor = new toastui.Editor({
        el: document.querySelector('#contents'), // 에디터를 적용할 요소 (컨테이너)
        height: '500px',                        // 에디터 영역의 높이 값 (OOOpx || auto)
        initialEditType: 'wysiwyg',            // 최초로 보여줄 에디터 타입 (markdown || wysiwyg)
        initialValue: '',                       // 내용의 초기 값으로, 반드시 마크다운 문자열 형태여야 함
        previewStyle: 'vertical',               // 마크다운 프리뷰 스타일 (tab || vertical)
        /* start of hooks */
        hooks: {
            addImageBlobHook: addImageBlobHook
        }
    });

    // 공지사항 수정
    noticeSubmitButton.addEventListener("click", (e) => {
        e.preventDefault();
        e.target.disabled = true;

        const formData = new FormData(noticeForm);

        for (const [key, value] of formData.entries()) {
            console.log(key, value);
        };

        const noticeData = {
            title: formData.get("title"),
            contents: editor.getHTML(),
            publicYn: formData.get("publicYn")
        }

        const noticeId = formData.get("noticeId");

        if (noticeId) {
            $.ajax({
                type: "put",
                url: "/api/notices/" + noticeId,
                data: JSON.stringify(noticeData),
                contentType: "application/json",
                success: (data) => {
                    console.log(data);
                    location.href = "/notices/edit/" + noticeId;
                },
                error: (error) => {
                    const data = JSON.parse(error.responseText)
                    alert(data.errorMessage);
                },
                complete: () => {
                    e.target.disabled = false;
                }
            })
        } else {
            $.ajax({
                type: "post",
                url: "/api/notices",
                data: JSON.stringify(noticeData),
                contentType: "application/json",
                success: (res) => {
                    console.log(res);
                    location.href = "/notices/edit/" + res.data;
                    alert(res);
                },
                error: (error, textStatus, a) => {
                    const data = JSON.parse(error.responseText)
                    alert(data.errorMessage);
                },
                complete: () => {
                    // e.target.disabled = false;
                }
            })
        }

    });

    // 이미지url 처리
    function addImageBlobHook(blob, callback) {  // 이미지 업로드 로직 커스텀
        const formData = new FormData();

        formData.set("file", blob);

        $.ajax({
            type: "post",
            url: "/api/noticesImg",
            data: formData,
            processData: false,
            contentType: false,
            success: (data) => {
                console.log(data);
                callback( data?.data )

            }, });

    }

    // 공지사항 삭제
    function noticeDeleteBtnClickHandler(e) {
        e.preventDefault();
        e.target.disabled = true;

        const noticeIdEl = document.querySelector("[name=noticeId]");

        if (confirm("정말로 삭제하시겠습니까?")) {
            $.ajax({
                type: "DELETE",
                url : "/api/notices/" + noticeIdEl.value,
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
            e.target.disabled = false;
        }
    }



});



