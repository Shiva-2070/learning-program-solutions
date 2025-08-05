import React from 'react';
import './App.css';

function App() {
  const officeList = [
    {
      name: 'Downtown Office',
      rent: 75000,
      address: '123 Main Street, City Center',
      image: 'https://img.freepik.com/free-photo/modern-office-space-interior_158595-5206.jpg',
    },
    {
      name: 'Suburban Workspace',
      rent: 55000,
      address: '456 Suburb Lane, Greenfield',
      image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3sKBOG8b3s2b0zxhWQX-fivRpv8Ln6pGGIQ&s',
    },
    {
      name: 'Tech Park Suite',
      rent: 95000,
      address: '789 IT Park Road, Silicon Hills',
      image: 'https://thumbs.dreamstime.com/b/office-work-place-5879959.jpg',
    },
  ];

  return (
    <div className="App">
      <h1>Office Space Rental Listings</h1>

      {officeList.map((office, index) => (
        <div key={index} className="office-card">
          <img src={office.image} alt={office.name} />
          <h2>{office.name}</h2>
          <p><strong>Address:</strong> {office.address}</p>
          <p>
            <strong>Rent:</strong>{' '}
            <span style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
              ₹{office.rent}
            </span>
          </p>
          <hr />
        </div>
      ))}
    </div>
  );
}

export default App;
