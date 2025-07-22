const PAGE_INIT = 0;
const PAGE_SIZE_DEFAULT = 5;
const BASE_URL = 'http://localhost:8081/';
var totalPage = 0;

function actionSearch() {
    // Gọi hàm search với PAGE_INIT và PAGE_SIZE_DEFAULT
    search(PAGE_INIT, PAGE_SIZE_DEFAULT);
}

function redirectPageCreateUser(){
    // Chuyển hướng đến trang tạo người dùng
    window.location.href = `${BASE_URL}` + "cms/create-user";
}

// 1. viết method search để gọi api lấy dữ liệu
function search(pageIndex, pageSize) {

    let params = new URLSearchParams();

    params.append('page', pageIndex);
    params.append('size', pageSize);
    // lấy giá trị từ các input tìm kiếm
    let username = document.getElementById("search-username").value;
    if (username) params.append('username', username);

    let fullName = document.getElementById("search-fullname").value;
    if (fullName) params.append('fullName', fullName);

    let age = document.getElementById("search-age").value;
    if (age) params.append('age', age);

    let fromDate = document.getElementById("from-date").value;
    if (fromDate) params.append('fromDate', fromDate);

    let toDate = document.getElementById("to-date").value;
    if (toDate) params.append('toDate', toDate);

    // Tạo URL với các tham số tìm kiếm
    let url = `${BASE_URL}` + 'api/v1/users?' + params.toString();

    // Gọi API để lấy dữ liệu
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            renderTable(data);
            renderPaging(data);
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}

// 2. viết method renderTable để hiển thị dữ liệu lên table
function renderTable(data) {
    // Lấy ra body của table
    let bodyTable = document.getElementById('bodyTableData');
    // Xóa bỏ toàn bộ dữ liệu đã có của table
    bodyTable.innerHTML = '';

    // Duyệt danh sách người dùng
    data.data.forEach(user => {
        let rowTable = `<tr>
                        <td><input type="checkbox" class="recordCheckbox"></td>
                        <td>${safeValue(user.code)}</td>
                        <td>${safeValue(user.username)}</td>
                        <td>${safeValue(user.fullName)}</td>
                        <td>${safeValue(user.age)}</td>
                        <td>${safeValue(user.phone)}</td>
                        <td>${safeValue(user.email)}</td>
                        <td>${safeValue(user.roleName)}</td>
                        <td>${safeValue(user.createdDate)}</td>
                        <td>${safeValue(user.address)}</td>
                    </tr>`;
        bodyTable.innerHTML += rowTable;
    });

}
function safeValue(value) {
    return (value === null || value === 'null') ? '' : value;
}

// 3. viết method renderPaging để hiển thị phân trang
function renderPaging(data) {
    // Lấy ra phần tử phân trang
    let pagingElement = document.getElementById('paginationId');
    // Xóa bỏ nội dung cũ của phân trang
    pagingElement.innerHTML = '';

    // Lấy tổng số trang từ dữ liệu
    totalPage = data.totalPage;
    pageIndex = data.pageIndex;

    // Tạo nút Previous
    let preIcon = `<li class="page-item"><a class="page-link" onclick="changePage(pageIndex > 0 ? ${pageIndex - 1} : 0)"><span aria-hidden="true">&laquo;</span></a></li>`;
    pagingElement.innerHTML += preIcon;
    // Tạo các nút trang
    for (let i = 0; i < totalPage; i++) {
        let pageIndexDisplay = i + 1;
        let activeClass = (i === pageIndex) ? 'active' : '';
        let pageItem = `<li class="page-item ${activeClass}"><a class="page-link" onclick="changePage(${i})">${pageIndexDisplay}</a></li>`;
        pagingElement.innerHTML += pageItem;
    }

    let nextIcon = `<li class="page-item"><a class="page-link" onclick="changePage(pageIndex < totalPage ? ${pageIndex + 1} : totalPage)"><span aria-hidden="true">&raquo;</span></a></li>`;
    pagingElement.innerHTML += nextIcon;
}

// 4. viết method changePage để thay đổi trang hiện tại
function changePage(pageIndex) {
    // Kiểm tra nếu pageIndex hợp lệ
    if (pageIndex < 0 || pageIndex >= totalPage) {
        return; // Không làm gì nếu pageIndex không hợp lệ
    }
    // Gọi hàm search với pageIndex và PAGE_SIZE_DEFAULT
    search(pageIndex, PAGE_SIZE_DEFAULT);
}

// 5 viết method window.onload để tự động gọi hàm search khi trang được tải
window.onload = function () {
    // Gọi hàm search với PAGE_INIT và PAGE_SIZE_DEFAULT
    search(PAGE_INIT, PAGE_SIZE_DEFAULT);
};