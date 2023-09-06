$(function () {
    const observerEl = document.getElementById("observer");
    const portfolioEl = document.getElementById("portfolio");

    let activeApi = true;
    const layouts = `
    <div class="portfolio-item img-zoom good">
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
        threshold: 0.8,
    };

    const observer = new IntersectionObserver((entries, io) => {
        entries.forEach( (entry) => {
            if (entry.isIntersecting) {
                 getNextGalleries();
            }
        });
    }, options);

    observer.observe(observerEl);

    function getNextGalleries() {
        if (!activeApi) return;
        $.ajax({
            url: `/api/galleries?page=${page}${yearType ? '&year='.concat(yearType) : ''}`,
            type: "GET",
            success : (res) => {
                page++;
                // if (res.galleries.length <= 0) {
                //     activeApi = false;
                //     let item = document.getElementById("noitems");
                //     item.innerHTML = "<div class='text-center'>게시글이 없습니다</div>"
                //     return;
                // }

                for (const d of res?.galleries || []) {
                    getDataLayouts(d);
                }


            },
            error : (error) => {
                console.log(error);
            }
        })
    }

    function getDataLayouts(data) {
        let lo = layouts;
        lo = lo.replaceAll("%%image%%", `<img src='${data.imageUri}' alt='image'/>`)
            .replaceAll("%%title%%", data.title)
            .replaceAll("%%contents%%", data.contents);

        const loEl = document.createRange().createContextualFragment(lo);
        portfolioEl.appendChild(loEl)
    }

})