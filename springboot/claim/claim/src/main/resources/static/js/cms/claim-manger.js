const PAGE_SIZE = 6;
const PAGE_INDEX_INIT = 0;
const BASE_URL = 'http://localhost:8081';


// khi nào tất cả page đã hiển thị thành công, sẽ chạy method trong này
window.onload = async function () {
    console.log('claim -manager console');

    // sử dụng fetch call api lấy json data từ api
    let jsonData = await callApi();
    // gắn json data từ api vào table
    renderTable(jsonData);
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
function callApi(){
    let url = BASE_URL + '/api/claim?page=' + PAGE_INDEX_INIT + '&size='+PAGE_SIZE;
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