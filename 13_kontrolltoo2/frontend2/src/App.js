import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [rivers, setTooted] = useState([]);
  const nimiRef = useRef(); // loeb input väärtusi sisse
  const startxRef = useRef();
  const startyRef = useRef();
  const endxRef = useRef();
  const endyRef = useRef();
  const speedRef = useRef();

  // võtmise api otspunkt
  useEffect(() => {
    fetch("http://localhost:8080/rivers")
      .then(response => response.json())
      .then(body => { // body or json
        setTooted(body);
      })
  }, []);

  // lisamise api otspunkt
  function lisa() {
    if (nimiRef.current.value.trim() === "") { // kontrollib, et väli poleks tühi. [trim() eemaldab tühikud]
      return;
    }

    const river = {
      "nimi": nimiRef.current.value,
      "start_x": startxRef.current.value,
      "start_y": startyRef.current.value,
      "end_x": endxRef.current.value,
      "end_y": endyRef.current.value,
      "speed": speedRef.current.value
    }
    fetch("http://localhost:8080/rivers",
    {
      "method": "POST", 
      "body": JSON.stringify(river), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json()) 
      .then(json => {
        setTooted(json);
      })
  }

  // kustutamise api otspunkt
  function kustuta(primaarvoti) {
    fetch("http://localhost:8080/rivers/" + primaarvoti, {"method": "DELETE"})
      .then(response => response.json()) 
      .then(json => {
        setTooted(json);
      })
  }

  return (
    <div className="App">
      <div>
        
        <label>Jõe nimi</label> <br/>
        <input ref={nimiRef} type="text" /> <br />
        <label>alguse x koordinaat</label> <br/>
        <input ref={startxRef} type="text" /> <br />
        <label>alguse y koordinaat</label> <br/>
        <input ref={startyRef} type="text" /> <br />
        <label>lõpu x koordinaat</label> <br/>
        <input ref={endxRef} type="text" /> <br />
        <label>lõpu y koordinaat</label> <br/>
        <input ref={endyRef} type="text" /> <br />
        <label>voolu kiirus</label> <br/>
        <input ref={speedRef} type="text" /> <br />
        <button onClick={() => lisa()}>Sisesta</button> <br />
        <br />

        {rivers.map(r =>
          <div>{r.id} | {r.nimi} | {r.speed}
            <button onClick={() => kustuta(r.id)}>x</button> 
          </div> )}
      </div>
    </div>
  );
}

export default App;