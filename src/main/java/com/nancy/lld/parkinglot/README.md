# Low-Level Design (LLD): Parking Lot System

## 1. Requirements Clarification & Scope

Before starting the class and component design, we need to clarify and confirm the core functional requirements.

> **Clarification Statement:**  
> *"Before I start designing the classes, I'd like to clarify a few requirements."*

---

### Core Clarification Questions

1. **Vehicle Types & Support:**
    * What vehicle types do we support? Cars, bikes, trucks?
2. **Parking Structure & Spot Allocation:**
    * Does the parking lot have multiple floors?
    * Are there different spot types? For example, bike, car, truck, handicapped/priority spots?
    * How should a parking spot be assigned? Any available compatible spot, nearest spot, same floor, etc.?
3. **Entry Workflow:**
    * What should happen when a vehicle enters? Should we issue a parking ticket containing entry time and assigned spot?
4. **Pricing Strategy:**
    * How is pricing calculated? Hourly, fixed rate, different rates by vehicle type?
5. **Exit Workflow:**
    * What happens on exit? Calculate fee → payment → release the spot?
6. **Real-time Status Display:**
    * Do we need to display availability, such as the number of free spots for each vehicle/spot type?

---

##  Scope & Requirements Answers

**Interviewer Response:**

Let's define our scope:

* **Multiple Floors:** The parking lot has multiple floors.
* **Vehicle & Spot Types:** We support Bike, Car, and Truck with corresponding Bike, Car, and Truck parking spots.
* **Entry Process:** When a vehicle enters, the system should find an appropriate available spot and issue a parking ticket containing the vehicle, spot, and entry time.
* **Spot Allocation:** For now, assign any available compatible spot. Later I may ask you to support something like nearest-spot allocation.
* **Exit Process & Fee Calculation:** On exit, calculate the parking fee based on the number of hours parked and vehicle type.
* **Payment Methods:** Assume payment can be Cash or Card.
* **Spot Release:** After successful payment, mark the parking spot available again.
* **Availability Tracking:** The system should also be able to tell us how many spots are currently available.
* **Out of Scope:** We don't need to model guards, employees, reservations, or special/female parking for now.

```
Multiple floors

Vehicle types:
- Bike
- Car
- Truck

Corresponding parking spots

Vehicle enters
→ find compatible spot
→ generate ticket

Vehicle exits
→ calculate hourly fee
→ payment via cash/card
→ release spot

Need available spot count

Spot allocation:
any compatible available spot for now

```

### Basic Flow
```
Vehicle enters
↓
Find compatible available spot
↓
Reserve/occupy spot
↓
Generate ticket
↓
Vehicle parked
↓
Vehicle exits
↓
Calculate fee
↓
Payment
↓
Free parking spot
```
---

## Step 2 — Identify the Entities

> *"What are the main things in this system that have their own data and/or behavior?"*

From our requirements, we identify these six main entities initially:

* **ParkingLot**
* **ParkingFloor**
* **ParkingSpot**
* **Vehicle**
* **ParkingTicket**
* **Payment**

```
                    ParkingLot
                        |
                  List of floors
                        |
                        ↓
                  ParkingFloor
                        |
                  List of spots
                        |
                        ↓
                  ParkingSpot
                        ↑
                        |
                     Vehicle

Vehicle + Spot + entryTime
          |
          ↓
    ParkingTicket
          |
          ↓
       Payment
```

### Entity Relationships Diagram

```
               ParkingLot
                   |
                   | 1:N
                   ↓
             ParkingFloor
                   |
                   | 1:N
                   ↓
              ParkingSpot
                   |
                   | 0..1
                   ↓
                Vehicle
                   |
                   |
             ParkingTicket
              /         \
             /           \
     ParkingSpot       Vehicle
             \
              \
               Payment

```
