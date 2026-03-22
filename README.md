<a name="readme-top"></a>

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![Apache 2.0 License][license-shield]][license-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY">
    <img src="app/src/main/res/mipmap-xxxhdpi/SHYAMAI.jpeg" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">SHYAMAI SMS Gateway</h3>

  <p align="center">
    Turns your Android smartphone into a powerful SMS gateway for sending and receiving messages via API.
    <br />
    <br />
    <a href="https://github.com/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY/issues">Report Bug</a>
    ·
    <a href="https://github.com/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
- [About The Project](#about-the-project)
  - [Features](#features)
  - [Ideal For](#ideal-for)
  - [Built With](#built-with)
- [Installation](#installation)
  - [Build Variants](#build-variants)
  - [Prerequisites](#prerequisites)
    - [Permissions](#permissions)
  - [Installation from APK](#installation-from-apk)
- [Getting Started](#getting-started)
  - [Local Server](#local-server)
  - [Cloud Server](#cloud-server)
  - [Webhooks](#webhooks)
    - [Supported Events](#supported-events)
    - [Setting Up Webhooks](#setting-up-webhooks)
- [Roadmap](#roadmap)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

<!-- ABOUT THE PROJECT -->
## About The Project

SHYAMAI SMS Gateway turns your Android smartphone into an SMS gateway. It's a lightweight application that allows you to send SMS messages programmatically via an API and receive webhooks on incoming SMS. This makes it ideal for integrating SMS functionality into your own applications or services.

### Features

📱 Core Functionality:

- 🆓 **No registration required:** No registration or email is required to create an account. In local mode, you don't need an account at all!
- 📨 **Send and Receive SMS via API:** Use our API to send messages directly from your applications or services.
- 🤖 **Support for Android 5.0 and above:** Compatible with Android 5.0 and later versions.

💬 Message Handling:

- 📜 **Multipart messages:** Send long messages with auto-partitioning.
- 📊 **Message status tracking:** Monitor the status of sent messages in real-time.
- 🔔 **Real-time incoming message notifications:** Receive instant SMS and MMS notifications via webhooks.
- 📖 **Read received messages:** Access previously received messages via the same webhooks used for real-time notifications.
- 📎 **MMS download notifications:** Receive webhook notifications when MMS messages are fully downloaded, including message body and attachments.

🔒 Security and Privacy:

- 🔐 **End-to-end encryption:** Encrypts message content and recipients' phone numbers before sending them to the API and decrypts them on the device.
- 🏢 **Private server support:** Use a backend server in your own infrastructure for enhanced security.

🔧 Advanced Features:

- 💳 **Multiple SIM card support:** Supports devices with multiple SIM cards.
- 📱📱 **Multiple device support:** Connect multiple devices to the same account.
- 💾 **Data SMS support:** Send and receive binary data payloads via SMS for IoT commands and other specialized use cases.

🔌 Integration:

- 🪝 **Webhooks:** Set up webhooks to be triggered on specified events.

### Ideal For

- 🔐 **Authentication & Verification:** Secure user accounts and transactions with SMS-based two-factor authentication.
- 📩 **Transactional Messages:** Send confirmation messages for user actions.
- ⏰ **SMS Reminders:** Prompt users about upcoming events or appointments.
- 🔔 **SMS Notifications:** Deliver immediate notifications for important updates and alerts.
- 📊 **User Feedback:** Solicit and collect user feedback through SMS.

*Note*: It is not recommended to use this for batch sending due to potential mobile operator restrictions.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

- [![Kotlin](https://img.shields.io/badge/Kotlin-000000?style=for-the-badge&logo=kotlin&logoColor=white)](https://kotlinlang.org/)
- [![Ktor](https://img.shields.io/badge/Ktor-000000?style=for-the-badge&logoColor=white)](https://ktor.io/)
- [![Room](https://img.shields.io/badge/Room-000000?style=for-the-badge&logoColor=white)](https://developer.android.com/training/data-storage/room)
- [![Firebase](https://img.shields.io/badge/Firebase-000000?style=for-the-badge&logo=firebase&logoColor=white)](https://firebase.google.com/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Installation

You can install the app to your device from the [Releases](https://github.com/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY/releases) page.

### Build Variants

The project provides two pre-built variants:

- **Secure (release) build**: Production-ready with strict security configurations. Recommended for production deployments.
- **Insecure build**: For development and testing with cleartext traffic allowed. **Never use in public environments.**

### Prerequisites

You need an Android device with Android 5.0 (Lollipop) or above.

#### Permissions

- **SEND_SMS**: Required to send SMS messages.
- **READ_PHONE_STATE**: Optional. Required to select the SIM card.
- **READ_SMS**: Optional. Required to read previous SMS messages.
- **RECEIVE_SMS**: Optional. Required to receive webhooks on incoming SMS.
- **RECEIVE_MMS**, **RECEIVE_WAP_PUSH**: Optional. Required to receive webhooks on incoming MMS messages.

### Installation from APK

1. Navigate to the [Releases](https://github.com/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY/releases) page.
2. Download the latest APK file.
3. Transfer the APK file to your Android device.
4. On your Android device, go to **Settings** > **Security** (or **Privacy** on some devices).
5. Enable the **Unknown sources** option.
6. Use a file manager app to navigate to the APK file.
7. Tap on the APK file to start the installation process.
8. Follow the on-screen prompts to complete the installation.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

The SHYAMAI SMS Gateway can work in two modes: with a **Local Server** started on the device or with a **Cloud Server**.

### Local Server

This mode is ideal for sending messages from a local network.

1. Launch the app on your device.
2. Toggle the `Local Server` switch to the "on" position.
3. Tap the `Offline` button at the bottom of the screen to activate the server.
4. Your device's local and public IP addresses will be displayed, along with basic auth credentials.
5. Send a message using curl:

    ```sh
    curl -X POST -u <username>:<password> \
      -H "Content-Type: application/json" \
      -d '{ "textMessage": { "text": "Hello!" }, "phoneNumbers": ["+19162255887"] }' \
      http://<device_local_ip>:8080/message
    ```

### Cloud Server

Use cloud server mode when dealing with dynamic or shared device IP addresses.

1. Launch the app on your device.
2. Toggle the `Cloud Server` switch to the "on" position.
3. Tap the `Online` button to connect to the cloud server.
4. Send a message using curl:

    ```sh
    curl -X POST -u <username>:<password> \
      -H "Content-Type: application/json" \
      -d '{ "textMessage": { "text": "Hello!" }, "phoneNumbers": ["+19162255887"] }' \
      https://api.sms-gate.app/3rdparty/v1/message
    ```

### Webhooks

Use webhooks to receive notifications for messaging events (e.g., incoming SMS and MMS).

#### Supported Events

| Event               | Description                                                                 |
| ------------------- | --------------------------------------------------------------------------- |
| `sms:received`      | Triggered when an SMS message is received                                   |
| `sms:sent`          | Triggered when an SMS message is sent                                       |
| `sms:delivered`     | Triggered when an SMS message is delivered                                  |
| `sms:failed`        | Triggered when an SMS message fails to send                                 |
| `sms:data-received` | Triggered when a data SMS is received                                       |
| `mms:received`      | Triggered when an MMS notification is received (before download)            |
| `mms:downloaded`    | Triggered when an MMS message is fully downloaded with body and attachments |
| `system:ping`       | Periodic heartbeat event                                                    |

#### Setting Up Webhooks

1. Set up your own HTTP server with a valid SSL certificate. For testing, [webhook.site](https://webhook.site) is useful.
2. Register your webhook:

    ```sh
    curl -X POST -u <username>:<password> \
      -H "Content-Type: application/json" \
      -d '{ "id": "unique-id", "url": "https://webhook.site/<your-uuid>", "event": "sms:received" }' \
      http://<device_local_ip>:8080/webhooks
    ```

3. Send an SMS to the device — the app will POST to your webhook URL.

4. To deregister a webhook:

    ```sh
    curl -X DELETE -u <username>:<password> \
      http://<device_local_ip>:8080/webhooks/unique-id
    ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [x] Add functionality to modify user credentials.
- [x] Introduce option to adjust the local server port.
- [x] Send notifications to an external server when the status of a message changes.
- [ ] Incorporate scheduling capabilities for dispatching messages at specific times.
- [ ] Implement region-based restrictions to prevent international SMS.
- [ ] Provide an API endpoint to retrieve the list of available SIM cards on the device.
- [x] Include detailed error messages in responses and logs.

See the [open issues](https://github.com/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY/issues) for a full list of proposed features and known issues.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request, or open an issue with the tag "enhancement".

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the Apache-2.0 license. See [LICENSE](LICENSE) for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

**SHAM MAWAL** — SHYAMAI SMS Gateway

- **GitHub:** [SHYAM-MAWAL](https://github.com/SHYAM-MAWAL)
- **Project Repository:** [https://github.com/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY](https://github.com/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY)
- **Issue Tracker:** [https://github.com/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY/issues](https://github.com/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY/issues)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
[contributors-shield]: https://img.shields.io/github/contributors/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY.svg?style=for-the-badge
[contributors-url]: https://github.com/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY.svg?style=for-the-badge
[forks-url]: https://github.com/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY/network/members
[stars-shield]: https://img.shields.io/github/stars/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY.svg?style=for-the-badge
[stars-url]: https://github.com/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY/stargazers
[issues-shield]: https://img.shields.io/github/issues/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY.svg?style=for-the-badge
[issues-url]: https://github.com/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY/issues
[license-shield]: https://img.shields.io/github/license/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY.svg?style=for-the-badge
[license-url]: https://github.com/SHYAM-MAWAL/SHYAMAI-SMS-GETWAY/blob/master/LICENSE
