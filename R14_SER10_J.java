
class SerializeSensorData {
    public static void main(String[] args) throws IOException {
      ObjectOutputStream out = null;
      try {
        out = new ObjectOutputStream(
            new BufferedOutputStream(new FileOutputStream("ser.dat")));
        while (SensorData.isAvailable()) {
          // Note that each SensorData object is 1 MB in size
          SensorData sd = SensorData.readSensorData();
          out.writeObject(sd);
          out.reset(); // Reset the stream
        }
      } finally {
        if (out != null) {
          out.close();
        }
      }
    }
  }