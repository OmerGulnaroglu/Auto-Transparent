INSERT INTO users (user_id, ad_soyad, telefon, email, sifre, rol) 
VALUES (1, 'Test Usta', '05550000000', 'testuser@example.com', 'password123', 'USTA')
ON CONFLICT (email) DO NOTHING;

INSERT INTO vehicles (vehicle_id, plaka, sase_no, marka_model, yil, sahip_id) 
VALUES (1, '06ABC001', 'SASE123456789', 'Toyota Corolla', 2023, 1)
ON CONFLICT (plaka) DO NOTHING;