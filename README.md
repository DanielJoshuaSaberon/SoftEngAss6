# SoftEngAss6
Lab Assignment 6 Observer pattern
Real-time News Subscription Service
Background
The goal of this project is to design a real-time news subscription service for a media company. The system ensures that subscribers are notified about breaking news as soon as it is published by the news agency.

Scenario Description
The system consists of two main components:

NewsAgency: Represents the central hub for publishing news. It maintains a list of subscribers and notifies them whenever new news is available.
Subscriber: Represents users or entities that are subscribed to the news service. Subscribers receive immediate notifications when new breaking news is published by the news agency.
Features
Subscription Management: Users can subscribe to the news service, and subscribers will be promptly notified when new news is published.
Dynamic Subscription Updates: Subscribers can dynamically subscribe, unsubscribe, or modify their preferences without affecting other subscribers.
Decoupled Communication: Subscribers do not directly request news updates but are notified by the news agency when new information is available.
Expected Behavior
When the news agency publishes breaking news, all subscribed users should receive immediate updates.
Subscribers can join or leave the service without affecting the delivery of news to other subscribers.
The system provides flexibility for future enhancements, such as personalized subscriptions or categorization of news updates.
Constraints
The system is designed to scale to handle a growing number of subscribers without compromising performance.
The implementation follows object-oriented design principles and promotes loose coupling between the news agency and subscribers.
