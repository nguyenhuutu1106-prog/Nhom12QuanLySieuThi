1. Truy vấn thông tin chi tiết nhân sự
Câu lệnh này dùng để xuất danh sách nhân viên với đầy đủ các thuộc tính quan trọng như ngày sinh, giới tính và số điện thoại để kiểm tra hồ sơ.
SELECT 
    [manv], 
    [tennv], 
    [chucvu], 
    [gioitinh], 
    [ngaysinh], 
    [sdt] 
FROM [QuanLySieuThi].[dbo].[nhanvien];
2. Lọc các mặt hàng sắp hết tồn kho
Giúp người quản lý biết được mặt hàng nào có số lượng tồn kho dưới 55 để lên kế hoạch nhập thêm.
SELECT 
    [id] AS MaSanPham, 
    [ten] AS TenSanPham, 
    [tonkho] AS SoLuongTon 
FROM [QuanLySieuThi].[dbo].[mathang]
WHERE [tonkho] < 55;
3. Tính toán tiền lãi dự kiến cho từng sản phẩm
Sử dụng phép trừ giữa giá bán và giá nhập để tính ra mức lợi nhuận thu được trên mỗi đơn vị sản phẩm.
SELECT 
    [id], 
    [ten], 
    [gia_nhap], 
    [gia_ban], 
    ([gia_ban] - [gia_nhap]) AS TienLai 
FROM [QuanLySieuThi].[dbo].[mathang];
4. Tìm kiếm nhà cung cấp theo khu vực
Sử dụng từ khóa LIKE để lọc ra tất cả các nhà cung cấp có địa chỉ nằm tại Hà Nội.
SELECT 
    [id], 
    [ten], 
    [diachi], 
    [sdt] 
FROM [QuanLySieuThi].[dbo].[nha_cung_cap]
WHERE [diachi] LIKE N'%Hà Nội%';
5. Thống kê tổng doanh thu theo từng nhân viên bán hàng
Sử dụng hàm gộp SUM() và GROUP BY để xem nhân viên nào mang lại nhiều doanh thu nhất từ bảng hóa đơn xuất.
SELECT 
    [nhan_vien] AS TenNhanVien, 
    COUNT([id]) AS SoLuongDonHang,
    SUM([thanh_tien]) AS TongDoanhThu 
FROM [QuanLySieuThi].[dbo].[hoa_don_xuat]
GROUP BY [nhan_vien];
6. Xem chi tiết các đơn nhập hàng có giá trị lớn (Trên 2 triệu)
Lọc các hóa đơn nhập có tổng thành tiền lớn hơn 2.000.000 VNĐ và sắp xếp từ cao xuống thấp.
SELECT 
    [id], 
    [ten_san_pham], 
    [nha_cung_cap], 
    [so_luong], 
    [thanh_tien], 
    [thoi_gian] 
FROM [QuanLySieuThi].[dbo].[hoa_don_nhap]
WHERE [thanh_tien] > 2000000
ORDER BY [thanh_tien] DESC;
7. Liệt kê tài khoản kèm theo chức vụ của nhân viên (Dùng JOIN)
Kết nối bảng tai_khoan và nhanvien thông qua mã nhân viên (manv) để biết tài khoản nào thuộc về ai và giữ chức vụ gì.
SELECT 
    tk.[ten_dang_nhap], 
    tk.[vai_tro], 
    nv.[tennv], 
    nv.[chucvu] 
FROM [QuanLySieuThi].[dbo].[tai_khoan] tk
JOIN [QuanLySieuThi].[dbo].[nhanvien] nv ON tk.[manv] = nv.[manv];
8. Thống kê tổng số lượng đã bán của từng mặt hàng
Nhóm dữ liệu theo tên sản phẩm trong bảng xuất hàng để biết sản phẩm nào đang bán chạy nhất.
SELECT 
    [ten_san_pham], 
    SUM([so_luong]) AS TongSoLuongDaBan 
FROM [QuanLySieuThi].[dbo].[hoa_don_xuat]
GROUP BY [ten_san_pham]
ORDER BY TongSoLuongDaBan DESC;
9. Lấy ra hóa đơn xuất gần đây nhất
Sử dụng TOP 1 và sắp xếp thời gian giảm dần (DESC) để lấy ra giao dịch bán hàng mới nhất của siêu thị.
SELECT TOP 1 
    [id], 
    [ten_san_pham], 
    [nhan_vien], 
    [so_luong], 
    [thanh_tien], 
    [thoi_gian] 
FROM [QuanLySieuThi].[dbo].[hoa_don_xuat]
ORDER BY [thoi_gian] DESC;
10. Tra cứu các đơn vị vận chuyển hỗ trợ giao hàng nội bộ
Kiểm tra xem đơn vị vận chuyển nào có tên chứa chữ "nội bộ" để phân bổ việc giao nhận cho các hóa đơn nhập hàng.
SELECT 
    [id], 
    [ten], 
    [diachi], 
    [sdt] 
FROM [QuanLySieuThi].[dbo].[don_vi_van_chuyen]
WHERE [ten] LIKE N'%nội bộ%';
