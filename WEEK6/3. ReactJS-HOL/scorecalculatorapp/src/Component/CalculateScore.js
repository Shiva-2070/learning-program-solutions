import '/Users/shiva/Desktop/My_react/scorecalculatorapp/src/Stylesheets/mystyle.css'
const calcScore = (total, goal) => {
    return <>
        {
            (total / goal).toFixed(2) + '%'
        }
    </>

}

const CalculateScore = ({ Name, School, Total, Goal }) => {
    return <div className="formatstyle">
        <h1><font color="Brown">Student Details</font>:</h1>
        <div className="Name">
            <b><span>Name:</span></b>
            <span>{Name}</span>
        </div>
        <div className="School">
            <b>School:</b>
            <span>{School}</span>
        </div>
        <div className="Total">
            <span><b>Total:</b></span>
            <span>{Total}</span>
        </div>
        <div className="Score">
            <b>Score:</b>
            <span>{calcScore(Total, Goal)}</span>

        </div>

    </div>
}
export default CalculateScore;