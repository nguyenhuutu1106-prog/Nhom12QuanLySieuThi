-- NHÓM 1: QUẢN LÝ KHO & SẢN PHẨM

SELECT * FROM mat_hang ORDER BY ten ASC;

-- Câu 1: Cảnh báo hàng tồn kho thấp (Tồn kho dưới 10) để kịp thời nhập thêm
SELECT id, ten, ton_kho FROM mat_hang WHERE ton_kho < 10;

-- Câu 2: Lọc ra các sản phẩm cao cấp có giá bán lớn hơn 100.000 VNĐ
SELECT ten, gia_ban FROM mat_hang WHERE gia_ban > 100000;

-- Câu 3: Tìm kiếm nhanh các mặt hàng theo từ khóa (Ví dụ: Tìm tất cả các loại "Sữa")
SELECT * FROM mat_hang WHERE ten LIKE N'%Sữa%';

-- Câu 4: Tính trung bình cộng giá bán của tất cả các mặt hàng đang kinh doanh
SELECT AVG(gia_ban) AS GiaBanTrungBinh FROM mat_hang;

-- NHÓM 2: THỐNG KÊ DOANH THU & LỢI NHUẬN

-- Câu 5: Tính tổng doanh thu thu được từ tất cả các hóa đơn bán ra
SELECT SUM(thanh_tien) AS TongDoanhThu FROM hoa_don_xuat;

-- Câu 6: Tính tổng chi phí vốn đã bỏ ra để nhập hàng về kho
SELECT SUM(thanh_tien) AS TongChiPhiNhapHang FROM hoa_don_nhap;

-- Câu 7: Tính toán mức biên độ lợi nhuận trên từng đơn vị sản phẩm (Giá bán - Giá nhập)
SELECT ten AS TenSanPham, gia_nhap, gia_ban, (gia_ban - gia_nhap) AS LoiNhuanTren1SP 
FROM mat_hang;

-- Câu 8: Trích xuất 5 hóa đơn bán hàng có giá trị cao nhất (Khách VIP)
SELECT TOP 5 * FROM hoa_don_xuat ORDER BY thanh_tien DESC;

-- NHÓM 3: ĐÁNH GIÁ NHÂN VIÊN & ĐỐI TÁC

-- Câu 9: Thống kê KPI - Đếm số lượng hóa đơn mỗi nhân viên thu ngân đã xử lý
SELECT nhan_vien, COUNT(id) AS SoDonDaBan 
FROM hoa_don_xuat 
GROUP BY nhan_vien;

-- Câu 10: Tra cứu thông tin của các nhân viên Nam đang giữ chức vụ 'Quản lý'
SELECT ten, sdt FROM nhan_vien 
WHERE gioi_tinh = N'Nam' AND chuc_vu = N'Quản lý';

-- Câu 11: Tìm kiếm các Nhà cung cấp có trụ sở tại TP HCM và số điện thoại đuôi '22'
SELECT ten, sdt, dia_chi FROM nha_cung_cap 
WHERE dia_chi LIKE N'%TP HCM%' AND sdt LIKE '%22';

-- NHÓM 4: TRUY VẤN NÂNG CAO (GỘP BẢNG, TÌM KIẾM SÂU)
-- -------------------------------------------------------

-- Câu 12: Truy xuất mặt hàng "Best Seller" (Bán được tổng số lượng nhiều nhất)
SELECT TOP 1 ten_san_pham, SUM(so_luong) AS TongSoLuongDaBan
FROM hoa_don_xuat
GROUP BY ten_san_pham
ORDER BY TongSoLuongDaBan DESC;

-- Câu 13: Thống kê tổng số tiền đã thanh toán cho từng Nhà cung cấp
SELECT nha_cung_cap, SUM(thanh_tien) AS TongTienDaNhap
FROM hoa_don_nhap
GROUP BY nha_cung_cap
ORDER BY TongTienDaNhap DESC;

-- Câu 14: Tìm các sản phẩm "Ế" (Đang nằm trong kho nhưng chưa từng được xuất bán)
SELECT id, ten, ton_kho FROM mat_hang 
WHERE ten NOT IN (
    SELECT DISTINCT ten_san_pham FROM hoa_don_xuat
);
