const PAGE_SIZE = 6;
const PAGE_INDEX_INIT = 0;
const BASE_URL = 'http://localhost:8081';


// khi nào tất cả page đã hiển thị thành công, sẽ chạy method trong này
window.onload = async function () {
    renderData(PAGE_INDEX_INIT);
}

function searchClaim(){
    renderData(PAGE_INDEX_INIT)
}

async function renderData(pageIndex){
    // sử dụng fetch call api lấy json data từ api
    let responseDataApi = await callApiClaim(pageIndex);
    // gắn json data từ api vào table
    renderTable(responseDataApi);
    // render cac page phan trang
    renderPaging(responseDataApi);
}

function renderPaging(responseDataApi){

    let currentPage = responseDataApi.pageIndex;
    //1. lay tổng số page response
    let totalPage = responseDataApi.totalPage;
    //2. lấy ra tag cha <ul class="pagination"> qua class = pagination
    let parentPaging = document.getElementsByClassName("pagination")[0];
    //3. reset html cua page
    parentPaging.innerHTML = '';
    //4. chạy vòng lap for theo total page và tạo ra các page
    for (let i = 0; i < totalPage; i++) {
        let pageIndexDisplay = i + 1;
        let page = `<li class="page-item"><a class="page-link" onclick="changePage(${i})">${pageIndexDisplay}</a></li>`
        if (i === currentPage){
            page = `<li class="page-item active"><a class="page-link" onclick="changePage(${i})">${pageIndexDisplay}</a></li>`
        }

        //5. gan các page vào thẻ ul cha
        parentPaging.innerHTML +=page;
    }
}

function changePage(indexPage){
    renderData(indexPage);
}

function renderTable(jsonData){
    let tbody = document.getElementById("claimTableBody");
    tbody.innerHTML = '';

    let data = jsonData.data;
    for (let i = 0; i < data.length; i++) {
        let claim = data[i];
        let row = `<tr>
                                    <td><input type="checkbox" id="selectAll"></td>
                                    <td>${claim.code}</td>
                                    <td>${claim.customerName}</td>
                                    <td>${claim.nameProduct}</td>
                                    <td>${claim.claimDate}</td>
                                    <td>${claim.coverageProduct}</td>
                                    <td>${claim.statusName}</td>
                                </tr>`
        tbody.innerHTML += row;
    }
}
function callApiClaim(pageIndex){
    // 1. lấy ra toàn bộ value tại các input search
    let claimCode = document.getElementById("search-ma-yeu-cau").value;
    let fromDate = document.getElementById('from-date').value;
    let toDate = document.getElementById('to-date').value;
    let statusCode = document.getElementById('trang-thai-yeu-cau').value;

    // 2. build url với các value để thành url http://localhost:8080/api/claim?page=0&size=6&claimCode=CLM0014&fromDate=2024-04-15&toDate=2024-04-19&codeStatus=
    let url = BASE_URL + '/api/claim?page=' + pageIndex + '&size='+PAGE_SIZE + `&claimCode=${claimCode}&fromDate=${fromDate}&toDate=${toDate}&codeStatus=${statusCode}`;
    /*
    fetch:
        chuyên được sử dụng để call api, thực hiện các tác vụ bất đồng bộ
        fetch sẽ trả về 1 promise
     */
    return fetch(url)
        .then(response => {
            // khi call api phản hồi sẽ chạy vào then đầu tiên này
            if (!response.ok){
                alert('call api error')
                throw new Error('call api error')
            }
            // tiếp tục trả về 1 promise
            return response.json();
        }).then(jsonData => {
            // sẽ được call vào sau return của then đầu tiên, đây chính là json data
            console.log(jsonData)
            return jsonData;
        })
}