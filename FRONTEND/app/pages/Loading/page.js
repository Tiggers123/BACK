import React from "react";
import styles from "./loading.module.css"; // Import CSS file for styling

const Loading = () => {
  return (
    <div className={styles.menuContainer}>
      <div className="rpgui-content">
        <p style={{textAlign: "center", fontSize: "32px", marginTop: "350px", fontFamily: "hello"}}>WAITING FOR ANOTHER PLAYER...</p>
      </div>
    </div>
  );
};

export default Loading;
