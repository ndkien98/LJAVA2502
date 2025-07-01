const selectedFiles = [];
const urlCreateClaim = 'http://localhost:8081/api/claim/create';

// code handle file in table
document.getElementById('file-upload').addEventListener('change', function (event) {
    const fileList = event.target.files;
    const documentList = document.getElementById('document-list');

    Array.from(fileList).forEach(file => {
        // Lưu vào mảng selectedFiles
        selectedFiles.push(file);

        const fileType = file.type.split('/')[1].toUpperCase();
        const uploadDate = new Date().toISOString().split('T')[0];

        const row = document.createElement('tr');

        const fileNameCell = document.createElement('td');
        fileNameCell.textContent = file.name;

        const fileTypeCell = document.createElement('td');
        fileTypeCell.textContent = fileType;

        const uploadDateCell = document.createElement('td');
        uploadDateCell.textContent = uploadDate;

        const actionCell = document.createElement('td');
        const viewButton = document.createElement('button');
        viewButton.className = 'btn btn-brand-2nd';
        viewButton.style.marginRight = '2%';
        viewButton.textContent = 'Xem';
        viewButton.addEventListener('click', () => {
            const url = URL.createObjectURL(file);
            window.open(url, '_blank');
        });

        const deleteButton = document.createElement('button');
        deleteButton.className = 'btn btn-brand-2nd';
        deleteButton.textContent = 'Xóa';
        deleteButton.addEventListener('click', () => {
            row.remove();
            const index = selectedFiles.indexOf(file);
            if (index > -1) {
                selectedFiles.splice(index, 1); // Xoá khỏi mảng khi xóa row
            }
        });

        actionCell.appendChild(viewButton);
        actionCell.appendChild(deleteButton);

        row.appendChild(fileNameCell);
        row.appendChild(fileTypeCell);
        row.appendChild(uploadDateCell);
        row.appendChild(actionCell);

        documentList.appendChild(row);
    });

    // Xóa file input sau khi load để có thể chọn lại file đã chọn
    event.target.value = '';
});


// gắn sự kiện khi click vào button thêm mới yêu cầu sẽ call vào vào method addClaim
document.getElementById("create-claim").addEventListener("click",addClaim);

// method addClaim
async function addClaim() {

    //1. lấy danh sách file để tạo object documents
    let documentsRequest = await getListDocumentRequest();

    //2. tạo object customer
    let customerRequest = {
        address: document.getElementById("customer-address").value,
        bankName: document.getElementById("customer-bank-name").value,
        bankNumber: document.getElementById("customer-bank-number").value,
        email: document.getElementById("customer-email").value,
        name: document.getElementById("customer-name").value,
        phoneNumber: document.getElementById("customer-phone").value
    }

    //3. tạo object body hoàn chỉnh
    let claimRequestBody = {
        nameProduct: document.getElementById("insurance-product").value,
        description: document.getElementById("claim-description").value,
        amount: document.getElementById("claim-amount").value,
        claimDate: document.getElementById("claim-date").value,
        customer: customerRequest,
        documents: documentsRequest
    }
    let stringJsonBody =JSON.stringify(claimRequestBody);
    console.log(stringJsonBody)
    //4. call api
    const response = await fetch(urlCreateClaim,{
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Accept": "*/*"
        },
        body: stringJsonBody
    })

    if (!response.ok){
        throw new Error(`Server error ${response.status}`)
    }
    const bodyJson = await response.json();
    alert(`Tạo claim với mã ${bodyJson.data} thành công`);
}

async function getListDocumentRequest() {
    //1.1 tạo document chứa danh sách object document
    let documentsRequest = [];
    //  1.2 duyệt danh sách file tại biến globe
    for (const file of selectedFiles) {
        // 1.3 lấy ra string base64 cua moi file
        const strBase64 = await convertFileToStBase64(file);
        //1.4 tạo object document
        let documentRequest = {
            documentName: file.name,
            documentType: file.type.split('/')[1],
            updateDate: new Date().toISOString().split('T')[0],
            fileBase64Encoded: strBase64
        }
        documentsRequest.push(documentRequest);
    }
    return documentsRequest;
}

// method convert file to strBase64
function convertFileToStBase64(file){
    return new Promise((resolve,reject) => {
        const render = new FileReader();
        render.readAsDataURL(file);
        render.onload = () =>resolve(render.result);
        render.onerror = error => reject(error);
    })
}

