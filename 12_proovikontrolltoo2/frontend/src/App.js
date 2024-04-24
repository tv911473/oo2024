import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [tooted, setTooted] = useState([]);
  const nimiRef = useRef();
  const hindRef = useRef();
  const aktiivneRef = useRef();

  useEffect(() => {
    fetch("http://localhost:8080/tooted")
      .then(response => response.json())
      .then(body => {
        setTooted(body);
      })
  }, []);

  function lisa() {
    if (nimiRef.current.value.trim() === "") {
      return;
    }
    const toode = {
      "nimi": nimiRef.current.value,
      "hind": hindRef.current.value,
      "aktiivne": aktiivneRef.current.checked
    }
    fetch("http://localhost:8080/tooted",
    {
      "method": "POST", 
      "body": JSON.stringify(toode), 
      "headers": {"Content-Type": "application/json"}
    })
      .then(response => response.json()) 
      .then(json => {
        setTooted(json);
      })
  }
  function kustuta(primaarivoti) {
    fetch("http://localhost:8080/tooted/" + primaarivoti, {"method": "DELETE"})
      .then(response => response.json()) 
      .then(json => {
        setTooted(json);
      })
  }

  return (
    <div className="App">
      <div>
        
        <label>Toote nimi</label> <br/>
        <input ref={nimiRef} type="text" /> <br />
        <label>Toote hind</label> <br/>
        <input ref={hindRef} type="text" /> <br />
        <label>Toote aktiivsus</label> <br/>
        <input ref={aktiivneRef} type="checkbox" /> <br />
        <button onClick={() => lisa()}>Sisesta</button> <br />
        <br />

        {tooted.map(t => 
          <div>{t.id} | {t.nimi} | {t.hind} | {t.aktiivne + 0} 
            <button onClick={() => kustuta(t.id)}>x</button> 
          </div> )}
      </div>
    </div>
  );
}

export default App;