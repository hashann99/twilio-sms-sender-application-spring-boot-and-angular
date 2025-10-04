# Bulk Message Sender with Twilio API

This project allows users to send personalized SMS messages to multiple customers with just one click.  
Users can upload an Excel file containing mobile numbers and custom messages, then either send immediately or schedule messages for later.
It uses the **Twilio SMS API** to handle message delivery securely and reliably.

# Features

- Upload Excel file with:
- Customer mobile numbers
- Personalized messages
-  One-click SMS sending via **Twilio API**
- Schedule messages for a future time
- Real-time sending status

# Tech Stack

- **Frontend**: Angular 
- **Backend**:  Spring Boot
- **Messaging Service**: [Twilio SMS API](https://www.twilio.com/sms)

# Twilio API Setup

To use Twilio SMS services, follow these steps:

1. Create a free account at [Twilio](https://www.twilio.com/).
2. Get your credentials:
   - Account SID
   - Auth Token
   - Twilio phone number
3. Create a `.env` file (or use environment variables) and add:

```env
TWILIO_ACCOUNT_SID=your_account_sid
TWILIO_AUTH_TOKEN=your_auth_token
TWILIO_PHONE_NUMBER=+1234567890







