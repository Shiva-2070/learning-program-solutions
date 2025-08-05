// components/FlightList.js
import React from 'react';

const flights = [
    { id: 1, flight: "Indigo 6E203", from: "Chennai", to: "Delhi", time: "10:30 AM" },
    { id: 2, flight: "Air India AI101", from: "Mumbai", to: "Kolkata", time: "02:45 PM" },
];

const FlightList = ({ showBooking }) => (
    <div>
        <h2>Available Flights</h2>
        <ul>
            {flights.map(f => (
                <li key={f.id}>
                    {f.flight} - {f.from} to {f.to} at {f.time}
                    {showBooking && <button>Book</button>}
                </li>
            ))}
        </ul>
    </div>
);

export default FlightList;
