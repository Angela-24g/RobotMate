$(function () {
    const pageContent = document.getElementById("page-content")
    const portfolioEl = document.getElementById("portfolio")
    let activeApi = false;
    const layouts = `
    <div class="portfolio-item img-zoom">
        <div class="portfolio-item-wrap">
            <div class="portfolio-image">
                <a href="#">
                    %%image%%
                </a>
            </div>
            <div class="portfolio-description">
                <a href="#">
                    <h3>%%title%%</h3>
                    <span>%%contents%%</span>
                </a>
            </div>
        </div>
    </div>
    `


    const options = {
        rootMargin: "0px",
        threshold: 1.0,
    };

    const observer = new IntersectionObserver((entries) => {
        // 관찰 중인 배열 형식의 객체 리스트
        entries.forEach((entry) => {
            if (entry.isIntersecting) {
                console.log(entry.isIntersecting)
                getNextGalleries();
            }
        });
    }, options);

    observer.observe(portfolioEl);

    function getNextGalleries() {
        if (!activeApi) {
            activeApi = true;
            return;
        }
        ++page;
        $.ajax({
            url: `/api/galleries?page=${page}${yearType ? '&year='.concat(yearType) : ''}`,
            type: "GET",
            success : (data) => {
                console.log(data);
            },
            error : (error) => {
                console.log(error);
            }
        })
    }
})