# Municipal tax alert system
Taxes are levied in almost every country of the world, primarily to raise revenue for government expenditures, although they serve other purposes as well. In general, the tax payment notices are circulated physically to the public demanding them the payment of the tax. In this era where each and every one is facilitated with a mobile phone our main objective of the project is to design a mobile application <b>"TAX NOTIFIER"</b> which sends the alerts to the users regarding the payment of the tax. The mobile app contains the database with the contact details and information regarding the tax payments of the public. The tax payment alerts are sent to the people through a message which contains the amount to be paid and the deadline of the payment.
# Lifecycle
<img src="https://user-images.githubusercontent.com/72719513/147077523-35c001d6-969b-4795-baab-1c12ee0850f1.png" width="600" height="500" />

# How the project works?
There is a 160 character text limit to SMS messages because they are transmitted over a narrow channel, and the protocol is specified by seven bits that can support 160 characters. I have used regional language(Telugu) which doesn't contain standard characters. The message has to convert into Unicode(which covers more size). <i><b>".sendMultipartTextMessage()"</b></i> function is used, which is the core functionality of this project. 

<img src="https://user-images.githubusercontent.com/72719513/147078567-d23f8e9d-c7f8-4053-b7d9-14fbef1d7a8c.png" width="700" height="500" />

# Outcome
## SMS alert in Telugu
This is the SMS alert received on the tax payer's mobile describing the 
1. Details of tax payer
2. Type of the tax to be paid
3. Amount to be paid
4. Link to proceed for payment
5. Deadline for the payment(without penalty)
Above all sending this in regional language!
<img src="https://user-images.githubusercontent.com/72719513/147077881-beb2a485-1462-42aa-83cf-6bcd9121ca17.png" width="300" height="500" />
