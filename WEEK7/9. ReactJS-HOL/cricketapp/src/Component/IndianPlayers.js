import React from 'react';

const IndianPlayers = () => {
    const allPlayers = ['Virat', 'Rohit', 'Dhoni', 'Raina', 'Gill', 'Bumrah'];

    const oddTeam = allPlayers.filter((_, i) => i % 2 === 0);  // index 0,2,4...
    const evenTeam = allPlayers.filter((_, i) => i % 2 !== 0); // index 1,3,5...

    const T20players = ['Surya', 'Hardik', 'Pant'];
    const RanjiPlayers = ['Pujara', 'Rahane'];

    const mergedPlayers = [...T20players, ...RanjiPlayers];

    return (
        <div>
            <h2>Odd Team Players</h2>
            <ul>
                {oddTeam.map((player, index) => (
                    <li key={index}>{player}</li>
                ))}
            </ul>

            <h2>Even Team Players</h2>
            <ul>
                {evenTeam.map((player, index) => (
                    <li key={index}>{player}</li>
                ))}
            </ul>

            <h2>Merged Players (T20 + Ranji)</h2>
            <ul>
                {mergedPlayers.map((player, index) => (
                    <li key={index}>{player}</li>
                ))}
            </ul>
        </div>
    );
};

export default IndianPlayers;
