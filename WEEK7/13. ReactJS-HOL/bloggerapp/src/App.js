import React, { useState } from 'react';
import BookDetails from './component/BookDetails';
import BlogDetails from './component/BlogDetails';
import CourseDetails from './component/CourseDetails';

function App() {
  const [view, setView] = useState("book");

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h1>Blogger App</h1>

  
      <div>
        <button onClick={() => setView("book")}>Show Book</button>
        <button onClick={() => setView("blog")}>Show Blog</button>
        <button onClick={() => setView("course")}>Show Course</button>
      </div>

      <hr />
      {
        (() => {
          if (view === "book") return <BookDetails />;
          else if (view === "blog") return <BlogDetails />;
          else return <CourseDetails />;
        })()
      }

    </div>
  );
}

export default App;
