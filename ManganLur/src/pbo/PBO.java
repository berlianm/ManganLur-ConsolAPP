/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo;
/**
 *
 * @author Acer
 */
import java.util.Scanner;
import java.sql.*;

public class PBO {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/manganlur";
    static final String USER = "root";
    static final String PASS = "";
    static Connection conn;
    static Statement stmt;
    static Statement stmt2;
    static Statement stmt3;
    static ResultSet rs;
    static ResultSet rs2;
    static ResultSet rs3;
    
    public static void main(String[] args) {
        boolean state = false;
        String username, password, nama, email, nik, nomorTelepon;
        String alamat, layanan, namaProduk, resto, review;
        int tempatDuduk, pemilik = 0, hargaProduk, jenis, n=0, i=0;
        
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            stmt2 = conn.createStatement();
            stmt3 = conn.createStatement();
            
            Scanner sc = new Scanner(System.in);
            int ch;
            while(true){
                ch = 0;
                View.menuAwal();
                ch = sc.nextInt();
                if(ch == 1){
                    View.menuAkun();
                    ch = sc.nextInt();
                    if(ch == 1){
                        System.out.println("===== REVIEWER =====");
                        sc.nextLine();
                        System.out.print("Username: "); username = sc.nextLine();
                        System.out.print("Password: "); password = sc.nextLine();
                        String sql = "SELECT * FROM user_review";
                        rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            i = rs.getInt("id");
                            if(username.equals(rs.getString("username"))){
                                if(password.equals(rs.getString("password"))){
                                    View.menuReviewer();
                                    ch = sc.nextInt();
                                    if(ch == 1){
                                        sc.nextLine();
                                        System.out.print("Nama Restoran: ");
                                        resto = sc.nextLine();
                                        sql = "SELECT * FROM restoran WHERE nama LIKE '%" + resto + "%'";
                                        rs2 = stmt2.executeQuery(sql);
                                        while(rs2.next()){
                                            System.out.println(rs2.getRow() + ". " + rs2.getString("nama"));
                                        }
                                        rs2.close();
                                    }else if(ch == 2){
                                        sc.nextLine();
                                        System.out.println("Nama Makanan/Minuman: ");
                                        namaProduk = sc.nextLine();
                                        sql = "SELECT menu.nama, menu.harga, restoran.nama FROM menu "
                                                + "JOIN restoran ON menu.id_restoran=restoran.id WHERE menu.nama LIKE '%" + namaProduk + "%'";
                                        rs2 = stmt2.executeQuery(sql);
                                        while(rs2.next()){
                                            System.out.println(rs2.getRow() + ". " + rs2.getString("menu.nama") + "\t" + rs2.getString("menu.harga") + " pada Restoran: " + rs2.getString("restoran.nama"));
                                        }
                                    }else if(ch == 3){
                                        sc.nextLine();
                                        rs2 = stmt2.executeQuery("SELECT * FROM restoran");
                                        while(rs2.next()){
                                            System.out.println(rs2.getInt("id") + ". " + rs2.getString("nama"));
                                        }
                                        System.out.println("Pilih id resto untuk direview");
                                        n = sc.nextInt();
                                        rs2.close();
                                        rs2 = stmt2.executeQuery("SELECT * FROM restoran");
                                        while(rs2.next()){
                                            if(n == rs2.getInt("id")){
                                                sc.nextLine();
                                                System.out.println("Review " + rs2.getString("nama") + ": ");
                                                review = sc.nextLine();
                                                sql = "INSERT INTO review_restoran(id_restoran, review, id_reviewer)"
                                                        + " VALUES(?, ?, ?)";
                                                PreparedStatement pre = conn.prepareStatement(sql);
                                                pre.setInt(1, rs2.getInt("id"));
                                                pre.setString(2, review);
                                                pre.setInt(3, rs.getInt("id"));
                                                pre.execute();
                                                pre.close();
                                            }
                                        }
                                        rs2.close();
                                    }else if(ch == 4){
                                        sc.nextLine();
                                        sql = "SELECT menu.id, menu.nama, menu.jenis, restoran.nama FROM menu "
                                                + "JOIN restoran ON menu.id_restoran=restoran.id";
                                        rs2 = stmt2.executeQuery(sql);
                                        while(rs2.next()){
                                            System.out.println(rs2.getInt("menu.id") + ". " + rs2.getString("menu.nama") + "\t" + rs2.getString("menu.jenis") +" pada Restoran: " + rs2.getString("restoran.nama"));
                                        }
                                        System.out.println("Pilih id resto untuk direview");
                                        n = sc.nextInt();
                                        rs2.close();
                                        rs2 = stmt2.executeQuery("SELECT * FROM menu");
                                        while(rs2.next()){
                                            if(n == rs2.getInt("id")){
                                                sc.nextLine();
                                                System.out.println("Review " + rs2.getString("nama") + ": ");
                                                review = sc.nextLine();
                                                sql = "INSERT INTO review_menu(id_menu, review, id_reviewer)"
                                                        + " VALUES(?, ?, ?)";
                                                PreparedStatement pre = conn.prepareStatement(sql);
                                                pre.setInt(1, rs2.getInt("id"));
                                                pre.setString(2, review);
                                                pre.setInt(3, rs.getInt("id"));
                                                pre.execute();
                                                pre.close();
                                            }
                                        }
                                        rs2.close();
                                    }
                                }
                            }
                        }
                    }else if(ch == 2){
                        sc.nextLine();
                        System.out.println("===== REVIEWER =====");
                        System.out.print("Nama    : "); nama = sc.nextLine();
                        System.out.print("Username: "); username = sc.nextLine();
                        System.out.print("Email   : "); email = sc.nextLine();
                        System.out.print("Password: "); password = sc.nextLine();
                        String sql = "INSERT INTO user_review(nama, username, email, password)"
                                + " VALUES(?, ?, ?, ?)";
                        PreparedStatement pre = conn.prepareStatement(sql);
                        pre.setString(1, nama);
                        pre.setString(2, username);
                        pre.setString(3, email);
                        pre.setString(4, password);
                        pre.execute();
                        pre.close();
                    }
                }else if(ch == 2){
                    View.menuAkun();
                    ch = sc.nextInt();
                    if(ch == 1){
                        System.out.println("===== PIHAK RESTORAN =====");
                        sc.nextLine();
                        System.out.print("Username: "); username = sc.nextLine();
                        System.out.print("Password: "); password = sc.nextLine();
                        String sql = "SELECT * from user_restoran";
                        rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            if(username.equals(rs.getString("username"))){
                                if(password.equals(rs.getString("password"))){
                                    rs2 = stmt2.executeQuery("SELECT * FROM restoran WHERE pihak_restoran = " + rs.getInt("id"));
                                    while(rs2.next()){
                                        View.menuPihakRestoran();
                                        ch = sc.nextInt();
                                        if(ch == 1){
                                            View.menuRestoran();
                                            ch = sc.nextInt();
                                            if(ch == 1){
                                                View.menuResto();
                                                ch = sc.nextInt();
                                                if(ch == 1){
                                                    rs3 = stmt3.executeQuery("SELECT * FROM menu WHERE id_restoran = " + rs2.getInt("id"));
                                                    while(rs3.next()){
                                                        System.out.println("===== DAFTAR MENU =====");
                                                        System.out.println(rs3.getRow() + ". " + rs3.getString("nama"));
                                                        System.out.println("===== DAFTAR MENU =====");
                                                    }
                                                    rs3.close();
                                                }else if(ch == 2){
                                                    sc.nextLine();
                                                    System.out.println("Nama : "); namaProduk = sc.nextLine();
                                                    System.out.println("Harga: "); hargaProduk = Integer.parseInt(sc.nextLine());
                                                    while(true){
                                                        System.out.println("Jenis (1 Makanan, 2 Minuman): ");
                                                        jenis = sc.nextInt();
                                                        if(jenis == 1){
                                                            sql = "INSERT INTO menu(nama, harga, jenis, id_restoran)"
                                                                + " VALUES(?, ?, 'Makanan', " + rs2.getInt("id") + ")";
                                                            PreparedStatement pre = conn.prepareStatement(sql);
                                                            pre.setString(1, namaProduk);
                                                            pre.setInt(2, hargaProduk);
                                                            pre.execute();
                                                            pre.close();
                                                            break;
                                                        }else if(jenis == 2){
                                                            sql = "INSERT INTO menu(nama, harga, jenis, id_restoran)"
                                                                + " VALUES(?, ?, 'Minuman', " + rs2.getInt("id") + ")";
                                                            PreparedStatement pre = conn.prepareStatement(sql);
                                                            pre.setString(1, namaProduk);
                                                            pre.setInt(2, hargaProduk);
                                                            pre.execute();
                                                            pre.close();
                                                            break;
                                                        }
                                                    }
                                                }else if(ch == 3){
                                                    rs3 = stmt3.executeQuery("SELECT * FROM menu WHERE id_restoran = " + rs2.getInt("id"));
                                                    while(rs3.next()){
                                                            System.out.println(rs3.getInt("id") + ". " + rs3.getString("nama") + "\tRp. " + rs3.getInt("harga"));
                                                    }
                                                    System.out.println("Pilihan Hapus ID: ");
                                                    ch = sc.nextInt();
                                                    rs3.close();
                                                    sql = "DELETE FROM menu WHERE id = ?";
                                                    PreparedStatement pre = conn.prepareStatement(sql);
                                                    pre.setInt(1, ch);
                                                    pre.execute();
                                                    pre.close();
                                                }else if(ch == 4){
                                                    rs3 = stmt3.executeQuery("SELECT * FROM menu WHERE jenis = 'makanan' AND id_restoran = " + rs2.getInt("id"));
                                                    while(rs3.next()){
                                                        System.out.println("===DETAIL MAKANAN===");
                                                        System.out.println(rs3.getRow() + ". " + rs3.getString("nama") + "\tRp. " + rs3.getInt("harga") + "\tJenis: " + rs3.getString("jenis"));
                                                        System.out.println("===DETAIL MAKANAN===");
                                                    }
                                                }else if(ch == 5){
                                                    rs3 = stmt3.executeQuery("SELECT * FROM menu WHERE jenis = 'minuman' AND id_restoran = " + rs2.getInt("id"));
                                                    while(rs3.next()){
                                                        System.out.println("===DETAIL MINUMAN===");
                                                        System.out.println(rs3.getRow() + ". " + rs3.getString("nama") + "\tRp. " + rs3.getInt("harga") + "\tJenis: " + rs3.getString("jenis"));
                                                        System.out.println("===DETAIL MINUMAN===");
                                                    }
                                                }else if(ch == 6){
                                                    System.out.println("SOON on GUI");
                                                }else if(ch == 7){
                                                    rs3 = stmt3.executeQuery("SELECT * FROM menu WHERE id_restoran = " + rs2.getInt("id"));
                                                    while(rs3.next()){
                                                        System.out.println("===DAFTAR HARGA===");
                                                            System.out.println(rs3.getRow() + ". " + rs3.getString("nama") + "\tRp. " + rs3.getInt("harga"));
                                                        System.out.println("===DAFTAR HARGA===");
                                                    }
                                                    rs3.close();
                                                }
                                            }
                                        }else if(ch == 2){
                                            System.out.println("===== FASILITAS =====");
                                            System.out.println("Terdapat " + rs2.getInt("tempat_duduk") +" kapasitas tempat duduk");
                                            System.out.println("Layanan yang diberikan adalah sistem " + rs2.getString("layanan"));
                                            System.out.println("===== FASILITAS =====");
                                        }
                                    }
                                    rs2.close();
                                }
                            }
                        }
                    }else if(ch == 2){
                        System.out.println("===== PIHAK RESTORAN =====");
                        sc.nextLine();
                        System.out.print("Nama    : "); nama = sc.nextLine();
                        System.out.print("Username: "); username = sc.nextLine();
                        System.out.print("Email   : "); email = sc.nextLine();
                        System.out.print("Password: "); password = sc.nextLine();
                        System.out.print("NIK     : "); nik = sc.nextLine();
                        System.out.print("Nomor Telepon: "); nomorTelepon = sc.nextLine();
                        String sql = "INSERT INTO user_restoran(nama, username, email, password, nik, nomor_telepon)"
                                + " VALUES(?, ?, ?, ?, ?, ?)";
                        PreparedStatement pre = conn.prepareStatement(sql);
                        pre.setString(1, nama);
                        pre.setString(2, username);
                        pre.setString(3, email);
                        pre.setString(4, password);
                        pre.setString(5, nik);
                        pre.setString(6, nomorTelepon);
                        pre.execute();
                        pre.close();
                        
                        System.out.print("Nama Restoran: "); nama = sc.nextLine();
                        System.out.print("Tempat Duduk : "); tempatDuduk = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Alamat : "); alamat = sc.nextLine();
                        System.out.print("Layanan: "); layanan = sc.nextLine();
                        System.out.print("Nomor Telepon: "); nomorTelepon = sc.nextLine();
                        rs = stmt.executeQuery("SELECT * FROM user_restoran");
                        while(rs.next()){
                            pemilik = Integer.parseInt(rs.getString("id"));
                        }
                        
                        sql = "INSERT INTO restoran(nama, tempat_duduk, alamat, layanan, nomor_telepon, pihak_restoran)"
                                + " VALUES(?, ?, ?, ?, ?, ?)";
                        pre = conn.prepareStatement(sql);
                        pre.setString(1, nama);
                        pre.setInt(2, tempatDuduk);
                        pre.setString(3, alamat);
                        pre.setString(4, layanan);
                        pre.setString(5, nomorTelepon);
                        pre.setInt(6, pemilik);
                        pre.execute();
                        pre.close();
                    }
                }else if(ch == 3){
                    View.menuAdmin();
                    ch = sc.nextInt();
                    if(ch == 1){
                        sc.nextLine();
                        System.out.print("Nama    : "); nama = sc.nextLine();
                        System.out.print("Username: "); username = sc.nextLine();
                        System.out.print("Email   : "); email = sc.nextLine();
                        System.out.print("Password: "); password = sc.nextLine();
                        System.out.print("NIK     : "); nik = sc.nextLine();
                        System.out.print("Nomor Telepon: "); nomorTelepon = sc.nextLine();
                        String sql = "INSERT INTO user_restoran(nama, username, email, password, nik, nomor_telepon)"
                                + " VALUES(?, ?, ?, ?, ?, ?)";
                        PreparedStatement pre = conn.prepareStatement(sql);
                        pre.setString(1, nama);
                        pre.setString(2, username);
                        pre.setString(3, email);
                        pre.setString(4, password);
                        pre.setString(5, nik);
                        pre.setString(6, nomorTelepon);
                        pre.execute();
                        pre.close();
                        
                        System.out.print("Nama Restoran: "); nama = sc.nextLine();
                        System.out.print("Tempat Duduk : "); tempatDuduk = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Alamat : "); alamat = sc.nextLine();
                        System.out.print("Layanan: "); layanan = sc.nextLine();
                        System.out.print("Nomor Telepon: "); nomorTelepon = sc.nextLine();
                        rs = stmt.executeQuery("SELECT * FROM user_restoran");
                        while(rs.next()){
                            pemilik = Integer.parseInt(rs.getString("id"));
                        }
                        
                        sql = "INSERT INTO restoran(nama, tempat_duduk, alamat, layanan, nomor_telepon, pihak_restoran)"
                                + " VALUES(?, ?, ?, ?, ?, ?)";
                        pre = conn.prepareStatement(sql);
                        pre.setString(1, nama);
                        pre.setInt(2, tempatDuduk);
                        pre.setString(3, alamat);
                        pre.setString(4, layanan);
                        pre.setString(5, nomorTelepon);
                        pre.setInt(6, pemilik);
                        pre.execute();
                        pre.close();
                    }else if(ch == 2){
                        rs = stmt.executeQuery("SELECT * FROM user_review");
                        System.out.println("===== REVIEWER ======");
                        while(rs.next()){
                            System.out.println(rs.getRow() + ". Nama Reviewer: " + rs.getString("nama") + "\tID: " + rs.getInt("id"));
                        }
                        System.out.println("===== REVIEWER ======\n");
                        rs.close();
                        System.out.println("===PENGELOLA RESTORAN===");
                        rs = stmt.executeQuery("SELECT * FROM user_restoran");
                        while(rs.next()){
                            System.out.println(rs.getRow() + ". Namam Resto: " + rs.getString("nama") + "\tID: " + rs.getInt("id"));
                        }
                        System.out.println("===PENGELOLA RESTORAN===\n");
                        rs.close();
                    }else if(ch == 3){
                        rs = stmt.executeQuery("SELECT * FROM user_review");
                        System.out.println("===== REVIEWER ======");
                        while(rs.next()){
                            System.out.println(rs.getRow() + ". Nama Reviewer: " + rs.getString("nama") + "\tID: " + rs.getInt("id"));
                        }
                        System.out.println("===== REVIEWER =====");
                        rs.close();
                        rs = stmt.executeQuery("SELECT * FROM user_restoran");
                        System.out.println("===PENGELOLA RESTORAN===");
                        while(rs.next()){
                            System.out.println(rs.getRow() + ". Namam Resto: " + rs.getString("nama") + "\tID: " + rs.getInt("id"));
                        }
                        System.out.println("===PENGELOLA RESTORAN===\n");
                        rs.close();
                    }else if(ch == 4){
                        View.pilihanUser();
                        ch = sc.nextInt();
                        if(ch == 1){
                            rs = stmt.executeQuery("SELECT * FROM user_review");
                            while(rs.next()){
                                System.out.println(rs.getInt("id")+ ". " + rs.getString("nama"));
                            }
                            System.out.println("Pilihan Hapus: ");
                            ch = sc.nextInt();
                            rs.close();
                            String sql = "DELETE FROM user_review WHERE id = ?";
                            PreparedStatement pre = conn.prepareStatement(sql);
                            pre.setInt(1, ch);
                            pre.execute();
                            pre.close();
                        }else if(ch == 2){
                            rs = stmt.executeQuery("SELECT * FROM user_restoran");
                            while(rs.next()){
                                System.out.println(rs.getInt("id") + ". " + rs.getString("nama"));
                            }
                            System.out.println("Pilihan Hapus: ");
                            ch = sc.nextInt();
                            rs.close();
                            String sql = "DELETE FROM user_restoran WHERE id = ?";
                            PreparedStatement pre = conn.prepareStatement(sql);
                            pre.setInt(1, ch);
                            pre.execute();
                            pre.close();
                        }
                    }
                }else if(ch == 9){
                    break;
                }
            }
             
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
