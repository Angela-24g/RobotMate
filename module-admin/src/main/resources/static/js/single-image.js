function SingleImage(element) {
    
    var _this = {
        // 허용 비디오 확장자 목록
        allowedVideoExtensions : ['mp4', 'avi', 'mov']
    };

    function init() {  
        _setting();
        _events();
    }

    function _setting() {
        // 메인 싱글 이미지 요소
        _this.element = element;
        // 파일 input 요소 
        _this.fileInputElement = _this.element.querySelector("[type=file]");
        // 파일 label 요소
        _this.fileLabelElement = _this.element.querySelector("label[for=" + _this.fileInputElement.id  + "]");
        // 파일 제거 버튼
        _this.removeFileButton = _this.element.querySelector("[data-single-image-close]");
        // 비디오 요소
        _this.videoViewElement = _this.element.querySelector("video");

        var singleImageType = _this.element.dataset.singleImageType; 
        var singleImageUrl = _this.element.dataset.singleImageUrl;

        if (singleImageType && singleImageUrl) {

            if (singleImageType.toLowerCase() === "video") {
                _visibility(_this.fileLabelElement, false);
                _visibility(_this.videoViewElement, true);
                _this.videoViewElement.src = singleImageUrl;
            } else {
                _visibility(_this.fileLabelElement, true);
                _visibility(_this.videoViewElement, false);
                _setLabelBackgroundImage(singleImageUrl);
            }

           
        }
    }

  
    /**
     * 이벤트 추가 
    */
    function _events() {
        if (_this.fileInputElement) _this.fileInputElement.addEventListener("change", _fileChangeHandler);
        if (_this.removeFileButton) _this.removeFileButton.addEventListener("click", _removeFileClickHandler);
    }

    /**
     * 파일 삭제 이벤트 핸들러
     */
    function _removeFileClickHandler() {
        _resetFileInput();  
    }

    /**
     * 파일 변경 이벤트 핸들러
     */
    function _fileChangeHandler(e) {
        _fileReader(e.target);  
    }

    /**
     * 파일 미리보기 
     */
    function _fileReader(input) {
        if (input.files && input.files[0]) {
         
            var reader = new FileReader();
            reader.onload = function(e) {
                var fileExtension = input.files[0].name.split('.').pop().toLowerCase();

                if (_isAllowedVideoExtensions(fileExtension)) {
                    _visibility(_this.fileLabelElement, false);
                    _visibility(_this.videoViewElement, true);
                    _this.element.setAttribute("data-single-image-type", 'video')
                    _this.videoViewElement.src = e.target.result;
                } else {
                    _visibility(_this.fileLabelElement, true);
                    _visibility(_this.videoViewElement, false);
                    _this.element.setAttribute("data-single-image-type", 'image')
                    _setLabelBackgroundImage(e.target.result);       
                }
            }
            reader.readAsDataURL(input.files[0]);
          } else {
            _resetFileInput();
          }
    }

    /**
     * 비디오 확장자 허용 여부
     */
    function _isAllowedVideoExtensions(fileExtension) {
       return _this.allowedVideoExtensions.includes(fileExtension);
    }

    /**
     * 보이게 또는 안보이게 설정
     * @param {Element} element 
     * @param {Boolean} visibility 
     */
    function _visibility(element, visibility) {
        if (visibility) {
            element.style.visibility = "visible";
        } else {
            element.style.visibility = "hidden";
        }
    }

    /**
     * 파일 input 초기화
     */
    function _resetFileInput() {
        _visibility(_this.fileLabelElement, true);
        _visibility(_this.videoViewElement, false);
        _this.fileLabelElement.style.backgroundImage = "url('/images/preview.png')";
        _this.fileInputElement.value = '';
        _this.videoViewElement.src = '';
        _this.element.setAttribute("data-single-image-type", 'image')
    }

    /**
     * 파일 미리보기 이미지 세팅
     * @param {String} url 
     */
    function _setLabelBackgroundImage(url) {
        _this.fileLabelElement.style.backgroundImage = "url('" + url + "')";   
    }


    init();
};


// 실행부
document.addEventListener(
    "DOMContentLoaded", 
() => document.querySelectorAll("[data-single-image]").forEach(el => new SingleImage(el)))