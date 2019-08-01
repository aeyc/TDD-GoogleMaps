<?php
session_start();
$connection = mysqli_connect('dijkstra.ug.bcc.bilkent.edu.tr', 'begum.tascioglu', '3Y2HxbNq', 'begum_tascioglu');
$_SESSION['apply']= "false";
if(! $connection)
{
    die('Connection Error!!! ' . mysqli_error());
}

function haversineGreatCircleDistance(
  $latitudeFrom, $longitudeFrom, $latitudeTo, $longitudeTo, $earthRadius = 6371000)
  {
    // convert from degrees to radians
    $latFrom = deg2rad($latitudeFrom);
    $lonFrom = deg2rad($longitudeFrom);
    $latTo = deg2rad($latitudeTo);
    $lonTo = deg2rad($longitudeTo);

    $latDelta = $latTo - $latFrom;
    $lonDelta = $lonTo - $lonFrom;

    $angle = 2 * asin(sqrt(pow(sin($latDelta / 2), 2) +
    cos($latFrom) * cos($latTo) * pow(sin($lonDelta / 2), 2)));
    return $angle * $earthRadius;
  }

   $i =1;
   $min = 1000000;
   $min_city_name = "";
   $query = "SELECT * FROM City";
   $result = $connection-> query($query);
   $loc_lat = $_GET['lat'];
   $loc_lng = $_GET['lng'];
   echo "lat of your location  : ".$loc_lat."<br>";
   echo "lng of your location : ".$loc_lng."<br>";
   $query = "SELECT * FROM City";
   $result = $connection-> query($query);
   $mincity_lat =0;
   $mincity_lng =0;
   if($result -> num_rows > 1)
   {
     while($row=$result->fetch_assoc()){
      $center_lat = $row['lat'];
      $center_lng = $row['lng'];
      $min_mayb = haversineGreatCircleDistance($loc_lat,$loc_lng,$center_lat,$center_lng,$earthRadius = 6371000);
      if ($min_mayb < $min ){
        $min = $min_mayb;
        $min_city_name = $row['name'];
        $mincity_lat =$row['lat'];
        $mincity_lng =$row['lng'];
      }
     }
      echo  "Coordinates of the nearest city- lat:".$mincity_lat." lng:". $mincity_lng."<br>";
     echo  "Nearest city: ".$min_city_name."<br>";
     echo "Distance to the nearest city: ".$min_mayb;
   }
   else{
     echo "error table not found";
   }
 ?>
