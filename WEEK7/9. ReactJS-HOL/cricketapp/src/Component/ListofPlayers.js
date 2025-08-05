import React from 'react';

const ListofPlayers = () => {
    const players = [
        { name: 'Virat', score: 95 },
        { name: 'Rohit', score: 85 },
        { name: 'Dhoni', score: 90 },
        { name: 'Raina', score: 68 },
        { name: 'Gill', score: 45 },
        { name: 'Bumrah', score: 76 },
        { name: 'Shami', score: 55 },
        { name: 'Surya', score: 99 },
        { name: 'Kohli', score: 70 },
        { name: 'Rahul', score: 30 },
        { name: 'Pant', score: 88 }
    ];

    const below70 = players.filter(player => player.score < 70);

    return (
        <div>
            <h2>All Players</h2>
            <ul>
                {players.map((player, index) => (
                    <li key={index}>{player.name} - {player.score}</li>
                ))}
            </ul>

            <h2>Players Scoring Below 70</h2>
            <ul>
                {below70.map((player, index) => (
                    <li key={index}>{player.name} - {player.score}</li>
                ))}
            </ul>
        </div>
    );
};

export default ListofPlayers;
