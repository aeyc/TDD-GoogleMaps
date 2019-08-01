package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {
	public static void main(String[] args) throws Exception 
	{
		dropCityTable();
		
		createCityTable();
		insertCity("Isparta",33.77 , 30.53);
		insertCity("Sivas",39.7454,37.035 ,);
		insertCity("Kilis",36.7204 ,37.12 );
		insertCity("Edirne",41.6704 ,26.57 );
		insertCity("Bingöl",38.885 ,40.498 );
		insertCity("Çorum",40.52 ,34.95 );
		insertCity("Iğdır",39.9237 ,44.045 );
		insertCity("Batman", 37.8904,41.14 );
		insertCity("Rize",41.0208 ,40.5219 );
		insertCity("Ardahan",41.1087 ,42.7022 );
		insertCity("Adıyaman",37.7704 ,38.2799 );
		insertCity("Bitlis",38.394 ,42.123 );
		insertCity("Trabzon",40.98 , 39.72);
		insertCity("Mardin",37.3115 ,40.7427 );
		insertCity("Gaziantep", 37.075, 37.385);
		insertCity("Sinop",42.023 ,35.153 );
		insertCity("Manisa",38.6304 ,27.44 );
		insertCity("Aydın",37.85 ,27.85 );
		insertCity("Giresun",40.913 ,38.39 );
		insertCity("Hatay",36.5804 ,36.17 );
		insertCity("Kahramanmaraş",37.61 ,36.945 );
		insertCity("Adana",36.995 , 35.32);
		insertCity("Osmaniye",37.0742 ,36.2478 );
		insertCity("ICINDEN ADAM CIKMAYAN BI YER",38.735 ,35.49 );
		insertCity("Samsun",41.28 ,36.3437 );
		insertCity("Yozgat",39.818 ,34.815 );
		insertCity("Amasya", 40.6537,35.833 );
		insertCity("Tokat",40.306 ,36.563 );
		insertCity("Niğde a.k.a ugursuzlarin yeri",37.976 ,34.694 );
		insertCity("Kırıkkale",39.8504 ,33.53 );
		insertCity("Burdur",37.7167 ,30.2833 );
		insertCity("Kırşehir",39.142 ,34.171 );
		insertCity("Karabük", 41.2, 32.6);
		insertCity("Karaman",37.1815 ,33.215 );
		insertCity("Nevşehir",38.624 ,34.724 );
		insertCity("Aksaray", 38.3725,34.0254 );
		insertCity("Afyon",38.7504 , 30.55);
		insertCity("Kastamonu",41.389 ,33.783 );
		insertCity("Bolu",40.7363 ,31.6061 );
		insertCity("Antalya",36.89 ,30.7 );
		insertCity("Konya",37.875 ,32.475 );
		insertCity("Çankırı", 40.607,33.621 );
		insertCity("Ankara",39.9272 ,32.8644 );
		insertCity("Balıkesir",39.6504 , 27.89);
		insertCity("Bartın", 41.6358,32.3375 );
		insertCity("Düzce", 40.8389,31.1639 );
		insertCity("Zonguldak",41.4304 ,31.78 );
		insertCity("Eskişehir", 39.795,30.53 );
		insertCity("Adapazarı",40.8 ,30.415 );
		insertCity("Izmit",40.776 ,29.9306 );
		insertCity("Yalova",40.655 ,29.2769 );
		insertCity("Bilecik",40.15 ,29.983 );
		insertCity("Istanbul",41.105 ,29.01 );
		insertCity("Denizli",37.7704 ,29.08 );
		insertCity("Muğla",37.2164 ,28.3639 );
		insertCity("Tekirdağ",40.9909 ,27.51 );
		insertCity("Kütahya",39.42 ,29.93 );
		insertCity("Kırklareli",41.743 ,27.226 );
		insertCity("Uşak",38.6804 ,29.42 );
		insertCity("Malatya",38.3704 ,38.3 );
		insertCity("Elazığ",38.68 ,39.23 );
		insertCity("Artvin",41.183 ,41.818 );
		insertCity("Şırnak",37.5139 ,42.4543 );
		insertCity("Hakkari",37.5744 ,43.7408 );
		insertCity("Gümüşhane",40.464 ,39.484 );
		insertCity("Tunceli",39.1167 ,39.5333 );
		insertCity("Bayburt",40.2563 ,40.2229 );
		insertCity("Erzincan",39.7526 ,39.4928 );
		insertCity("Ağrı", 39.7198,43.0513 );
		insertCity("Muş",38.749 ,41.4969 );
		insertCity("Izmir", 38.4361,27.1518 );
		insertCity("Van",38.4954 ,43.4 );
		insertCity("Kars",40.6085 ,43.0975 );
		insertCity("Diyarbakır",37.9204 ,40.23 );
		insertCity("Erzurum",39.9204 ,40.23 );
		insertCity("Bursa",40.2 ,29.07 );
		insertCity("Çanakkale",40.1459 ,26.4064 );
		insertCity("Mersin",36.8004 ,34.6128 );
		insertCity("Ordu",41.0004 ,37.8699 );
		insertCity("Siirt",37.944 ,41.933 );
		insertCity("Şanlıurfa",37.17 ,38.795 );




	}
	
	
	
	public static void dropCityTable()
	throws Exception
	{
		try
		{
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("DROP TABLE City");
			posted.executeUpdate();
		}
		catch (Exception e) {System.out.println(e);}
		finally
		{
			System.out.println("Drop complete");
		}
	}
	
	public static void insertCity(String name, long lat, long lng)
	throws Exception
	{
		try
		{
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO City"
					+ "(name, lat,lng)"
					+ "VALUES ('" +name + "', '" +lat+", "+ lng + "' )");
			posted.executeUpdate();
		}
		catch (Exception e) {System.out.println(e);}
		finally
		{
			System.out.println("Insert complete");
		}
	}
	
	public static void createCityTable()
	{
		try
		{
			Connection connection = getConnection();
			PreparedStatement cityT = connection.prepareStatement("CREATE TABLE IF NOT EXISTS City( "
										+ "name VARCHAR(64), lat VARCHAR(64),long VARCHAR(64) )"
										+ "Engine=InnoDB");
			cityT.executeUpdate();
		}
		catch (Exception e) {System.out.print(e);}
		finally{System.out.println("Table created");}
	}

	public static Connection getConnection() throws Exception 
	{
		try 
		{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://dijkstra.ug.bcc.bilkent.edu.tr/begum_tascioglu";
			String username = "begum.tascioglu";
			String password = "3Y2HxbNq";
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");
			
			return con;
			
		}catch(Exception e) {System.out.print(e);}
		
		return null;
	}

}
