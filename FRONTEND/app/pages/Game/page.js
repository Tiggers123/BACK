"use client";
import React, { useState } from "react";
import HexGrid from "../components/HexGrid";
import CountTimer from "../components/CountTimer";
import styles from "./game.module.css";
import AceEditor from "react-ace";
import "ace-builds/src-noconflict/mode-java";
import "ace-builds/src-noconflict/theme-dracula";
import "ace-builds/src-noconflict/ext-language_tools";

const App = () => {
  const [planText, setPlanText] = useState("");
  const [errorMgs, setErrorMgs] = useState(null);

  return (
    <div className={styles.bg}>
      <div className={styles.appcontainer}>
        <div className={styles.plan}>
          <div className={styles.cstcontainer}>
            <CountTimer
              countdownTimestampMs={Date.now() + 7 * 60 * 1000}
              minutes={7}
              seconds={0}
            />
            <div className={styles.regions}>
              <HexGrid column={8} row={8} />
            </div>
            <div className={styles.line}>
              <span>BUDGET : 500</span>
              <span style={{ marginLeft: "20px" }}>DEPOSIT : 400</span>
            </div>
            <div className={styles.line}>
              <span>ROW : 9</span>
              <span style={{ marginLeft: "20px" }}>COLUMN : 9</span>
            </div>
          </div>
          <div className={styles.wrappercontainer}>
            {" "}
            <p
              style={{
                fontFamily: "Lover",
                fontSize: "30px",
                marginBottom: "10px",
              }}
            >
              CONSTRUCTION PLAN
            </p>
            <AceEditor
              className="my-editor"
              mode="java"
              theme="dracula"
              name="plan-editor"
              editorProps={{ $blockScrolling: true }}
              fontSize="13px"
              setOptions={{
                fontFamily: "Monaco",
                enableBasicAutocompletion: true,
                enableLiveAutocompletion: true,
                enableSnippets: true,
                enableMultiselect: true,
              }}
              onChange={(e) => {
                setPlanText(e);
                setErrorMgs("");
              }}
            />
            <div className={styles.buttoncontainer}>
              <button class={styles.button}>
                <span class={styles.buttontext}>CONFIRM</span>
                <div class={styles.fillcontainer}></div>
              </button>
              <button class={styles.checkbutton} style={{ marginLeft: "20px" }}>
                <span class={styles.checkbuttontext}>RESET</span>
                <div class={styles.checkfillcontainer}></div>
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default App;
