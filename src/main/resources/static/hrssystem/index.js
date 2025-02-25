// 🚀 [1] 예약 전체조회 (목록 형태, axios의 Promise 방식 사용)
const loadReservations = () => {
  axios.get('/api/appointments')  // REST API 호출
    .then(response => {
      let listHtml = '<ul class="list-group">';
      response.data.forEach(reservation => {
        listHtml += `<li class="list-group-item">
          예약 ID: ${reservation.appointmentid}, 환자명: ${reservation.pname},
          의사명: ${reservation.dname}, 상태: ${reservation.status === 1 ? '예약확정' : '취소됨'}
        </li>`;
      });
      listHtml += '</ul>';
      document.getElementById('reservation-list').innerHTML = listHtml;
    })
    .catch(error => {
      console.error('API 호출 오류:', error);
    });
};

// 🚀 [2] 예약 전체조회 (테이블 업데이트, async/await 사용하여 비동기 처리)
const onFindAll = async () => {
  try {
    const response = await axios.get('/api/appointments');
    const tbody = document.querySelector('tbody');
    let html = '';
    response.data.forEach(reservation => {
      html += `<tr>
        <td>${reservation.appointmentid}</td>
        <td>${reservation.pname}</td>
        <td>${reservation.dname}</td>
        <td>${reservation.status === 1 ? '예약확정' : '취소됨'}</td>
        <td>${reservation.dcontent}</td>
        <td>
          <button class="btn btn-sm btn-warning me-2" onclick="onUpdate(${reservation.appointmentid})">수정</button>
          <button class="btn btn-sm btn-danger" onclick="onDelete(${reservation.appointmentid})">삭제</button>
        </td>
      </tr>`;
    });
    tbody.innerHTML = html;
  } catch (e) {
    console.error(e);
  }
};

// 🚀 [3] 예약 등록 함수 (axios 비동기 호출)
const onSave = () => {
  const patientid = document.getElementById('pid').value;
  const doctorid = document.getElementById('dname').value;
  const status = document.getElementById('status').value;
  const appointmentdate = document.getElementById('appointmentdate').value;
  const appointmenttime = document.getElementById('appointmenttime').value;
  const dcontent = document.getElementById('dcontent').value;

  const obj = { patientid, doctorid, status, appointmentdate, appointmenttime, dcontent };

  axios.post('/api/appointments', obj)  // 예약 등록 API 호출
    .then(response => {
      console.log('등록 결과:', response.data);
      loadReservations();  // 예약 목록 갱신
      document.getElementById('reservationForm').reset();  // 폼 초기화
    })
    .catch(e => { console.error(e); });
};

// 🚀 [4] 예약 수정 함수 (axios async/await 사용)
const onUpdate = async (pid) => {
  const hname = prompt('새로운 병원명 입력:');
  const status = prompt('새로운 상태 입력:');
  const pname = prompt('새로운 환자명 입력:');
  const dname = prompt('새로운 의사명 입력:');
  const dcontent = prompt('새로운 예약 내용 입력:');

  const obj = { hname, status, pname, dname, dcontent };

  try {
    const response = await axios.put(`/api/appointments/${pid}`, obj);  // 수정 API 호출
    if (response.data == 1) {
      onFindAll();
      loadReservations();
    }
  } catch (e) {
    console.error(e);
  }
};
// 🚀 [5] 예약 삭제 함수 (axios async/await 사용)
const onDelete = async (pid) => {
  try {
    const response = await axios.delete(`/api/appointments/${pid}`);  // 삭제 API 호출
    if (response.data == 1) {
      onFindAll();
      loadReservations();
    }
  } catch (e) {
    console.error(e);
  }
};

// 페이지 로딩 시 전체 조회 실행
document.addEventListener('DOMContentLoaded', () => {
  loadReservations();  // 예약 목록을 ul로 불러오기
  onFindAll();  // 테이블 형식으로 예약 목록 표시
});