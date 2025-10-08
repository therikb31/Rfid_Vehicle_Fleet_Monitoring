# Live Fleet Monitoring System (RFID-based)

A **Java J2EE-based live fleet monitoring system** that tracks and visualizes RFID-tagged vehicles in real time.
The system logs each vehicle’s passage through RFID reader booths, stores detailed vehicle data, and provides live map visualization for monitoring fleet movement.

---

## 🚀 Features

* **RFID Integration:**
  Detects and logs RFID-tagged vehicles as they pass through designated reader booths.

* **Real-Time Monitoring:**
  Displays live vehicle positions on an interactive map interface.

* **Historical Tracking:**
  Maintains a searchable history of all vehicle passages, including timestamps, booth IDs, and vehicle identifiers.

* **Web Dashboard:**
  Provides an intuitive web interface for operators to view live data, generate reports, and analyze movement trends.

* **Database Logging:**
  Each event is securely stored in a relational database for audit and analysis.

---

## 🧱 Tech Stack

| Component     | Technology                                                 |
| ------------- | ---------------------------------------------------------- |
| Backend       | Java EE (Servlets, JSP, JDBC)                              |
| Frontend      | JSP, HTML5, CSS, JavaScript                                |
| Database      | MySQL                                                      |
| Mapping       | OpenStreetMaps                                             |
| Server        | Apache Tomcat                                              |

---

## ⚙️ Installation & Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/therikb31/nkdaswm.git
   cd nkdaswm
   ```

2. **Deploy on Tomcat**

   * Build the project into a `.war` file.
   * Deploy it to your Tomcat server’s `webapps/` directory.
   * Start the Tomcat server and open:

     ```
     http://localhost:8080/nkdaswm
     ```

3. **Connect RFID Reader**

   * Configure your RFID reader’s IP/port or serial interface as per your hardware setup.
   * Ensure the reader sends tag data to the server endpoint configured in the project.

---

## 🗺️ Usage

* **Live View:** Monitor vehicle positions on a real-time map.
* **History:** View logs of all RFID read events with timestamps.
* **Reports:** Export data for selected time ranges or vehicles.

---

## 🧑‍💻 Author

**Rik Biswas**
GitHub: [@therikb31](https://github.com/therikb31)

---
