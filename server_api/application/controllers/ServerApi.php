<?php
	defined('BASEPATH') OR exit('No direct script access allowed');
	class ServerApi extends CI_Controller {
		// fungsi create
		public function addStaff() {
			// deklarasi variable
			$name = $this->input->post('name');
			$hp = $this->input->post('hp');
			$address = $this->input->post('address');

			$data['staff_name'] = $name;
			$data['staff_hp'] = $hp;
			$data['staff_address'] = $address;
			$q = $this->db->insert('tb_staff', $data);

			if($q) {
				$response['pesan'] = 'Berhasil memasukkan data';
				$response['status'] = 200;
			} else {
				$response['pesan'] = 'Gagal memasukkan data';
				$response['status'] = 404;
			}
			echo json_encode($response);
		}

		// fungsi read
		public function getDataStaff() {
			// deklarasi variable
			$q = $this->db->get('tb_staff');

			if($q->num_rows() > 0) {
				$response['pesan'] = 'Data tersedia';
				$response['status'] = 200;

				$response['staff'] = $q->row();
				$response['staff'] = $q->result();
			} else {
				$response['pesan'] = 'Data tidak tersedia';
				$response['status'] = 404;
			}
			echo json_encode($response);
		}

		// fungsi update
		public function updateStaff() {
			// deklarasi variable
			$id = $this->input->post('id');
			$name = $this->input->post('name');
			$hp = $this->input->post('hp');
			$address = $this->input->post('address');
			$this->db->where('staff_id', $id);

			$data['staff_name'] = $name;
			$data['staff_hp'] = $hp;
			$data['staff_address'] = $address;
			$q = $this->db->update('tb_staff', $data);

			if($q) {
				$response['pesan'] = 'Berhasil mengubah data';
				$response['status'] = 200;
			} else {
				$response['pesan'] = 'Gagal mengubah data';
				$response['status'] = 404;
			}
			echo json_encode($response);
		}

		// fungsi delete
		public function deleteStaff() {
			// deklarasi variable
			$id =$this->input->post('id');
			$this->db->where('staff_id', $id);
			$status = $this->db->delete('tb_staff');

			if($status == true) {
				$response['pesan'] = 'Berhasil menghapus data';
				$response['status'] = 200;
			} else {
				$response['pesan'] = 'Gagal menghapus data';
				$response['status'] = 404;
			}
			echo json_encode($response);
		}
	}
?>
